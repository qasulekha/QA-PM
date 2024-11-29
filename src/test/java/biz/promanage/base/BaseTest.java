package biz.promanage.base;

import biz.promanage.constants.DriverType;
import biz.promanage.driverManager.DriverFactory;
import biz.promanage.driverManager.DriverManager;
import biz.promanage.reports.ExtentManager;
import biz.promanage.utils.*;
import biz.promanage.utils.FileReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.apache.logging.log4j.ThreadContext;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class BaseTest {

    private final ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ExtentTest test;
    protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    public TestLogger logger = new TestLogger();
    FileReader fileReader = new FileReader();

    private void setDriverManager(DriverManager driverManager) {
        this.driverManager.set(driverManager);
    }

    protected DriverManager getDriverManager() {
        return this.driverManager.get();
    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser, Method m) throws Exception {
        browser = System.getProperty("browser", browser);
        initializeDriver(browser);
        test = ExtentManager.startTest(m.getName(), "Starting test: " + m.getName());
        initializeLogger(browser);
        initializeXmlFileReader();
        Otp.resetMobileNumber(GetUserLoginCred());
    }

    private void initializeDriver(String browser) {
        setDriverManager(DriverFactory.getDriverManager(DriverType.valueOf(browser)));
        setDriver(getDriverManager().getDriver());
    }

    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    @AfterMethod
    public synchronized void quitDriver(ITestResult result) throws InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            String screenshotPath = takeScreenshot(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            LogTestResults(result);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }

        ExtentManager.getReporter().flush();
        Thread.sleep(300);
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());
        getDriverManager().getDriver().quit();
    }

    private void LogTestResults(ITestResult result) {
        if (result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            logger.log().error(sw.toString());
        }
    }

    public String takeScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String screenshotName = "Promanage" + "_" + testName + "_" + DateTimeUtil.getDateTime() + ".png";
        String imagePath = "screenshots" + File.separator + screenshotName;

        byte[] encoded = null;
        try {
            FileHandler.copy(srcFile, new File(imagePath));
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String azureFilePath = "http://lscdn.azureedge.net/jenkins/Capshine/" + screenshotName;
        File imageSrc = new File(imagePath);

        try {
            FileUtils.copyFile(srcFile, new File(imagePath));
            AzureFileUpload.ScreenShot(imageSrc);
            Reporter.log("<a href='" + azureFilePath + "'> <img src='" + azureFilePath + "' height='400' width='400'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentManager.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
        return azureFilePath;
    }

    public JSONObject GetData(String path) throws IOException {
        JSONObject jsonObj;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            assert inputStream != null;
            JSONTokener jsonToken = new JSONTokener(inputStream);
            jsonObj = new JSONObject(jsonToken);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return jsonObj;
    }

    public String GetUserLoginCred() throws IOException {
        JSONObject loginUsers;
        InputStream inputStream = null;

        try {
            String dataFileName = "data/UserCred.json";
            inputStream = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener jsonToken = new JSONTokener(inputStream);
            loginUsers = new JSONObject(jsonToken);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return (String) loginUsers.getJSONObject("user9080610306").get("mobileNo");
    }

    private void initializeXmlFileReader() throws Exception {
        String xmlFileName = "data/ValidationText.xml";
        InputStream validationTextIs = null;
        validationTextIs = getClass().getClassLoader().getResourceAsStream(xmlFileName);
        setStrings(fileReader.parseStringXML(validationTextIs));
    }

    private void initializeLogger(String browser) {

        String strFile = "logs" + File.separator + browser;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }

        ThreadContext.put("ROUTINGKEY", strFile);
        logger.log().info("log path: " + strFile);
    }

    protected ExtentTest getTest() {
        return test;
    }

    public void clearScreenshots() {
        File screenshotDirectory = new File("./screenshots");
        if (screenshotDirectory.exists() && screenshotDirectory.isDirectory()) {
            try {
                FileUtils.cleanDirectory(screenshotDirectory);
            } catch (IOException e) {
                System.out.println("Failed to delete the screenshots");
            }

        }
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        clearScreenshots();
        Otp.resetMobileNumber(GetUserLoginCred());
        ThreadContext.put("ROUTINGKEY", "ServerLogs");
    }
}
