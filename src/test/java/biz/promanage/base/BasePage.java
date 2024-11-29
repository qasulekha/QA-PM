package biz.promanage.base;

import biz.promanage.driverManager.DevToolsHelper;
import biz.promanage.utils.AzureFileUpload;
import biz.promanage.utils.ConfigLoader;
import biz.promanage.utils.DateTimeUtil;
import biz.promanage.reports.ExtentManager;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.Duration;
import java.util.Random;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final Duration POLLING_INTERVAL = Duration.ofMillis(500);
    private static final String SCREENSHOTS_DIR = "screenshots";
    private static final String AZURE_BASE_URL = "http://lscdn.azureedge.net/jenkins/Capshine/";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ExtentTest test;
    protected FluentWait<WebDriver> fluentWait;

    public BasePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        this.fluentWait = new FluentWait<>(driver).withTimeout(DEFAULT_TIMEOUT).pollingEvery(POLLING_INTERVAL).ignoring(ElementClickInterceptedException.class).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
    }

    public static void sendDelayedKeys(WebElement element, String text) {
        if (element == null || text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Element or text cannot be null or empty.");
        }

        Random random = new Random();
        for (char c : text.toCharArray()) {
            try {
                Thread.sleep((long) (random.nextGaussian() * 15 + 300));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted during sendDelayedKeys", e);
            }
            element.sendKeys(String.valueOf(c));
        }
    }

    public static void ctrlF5Reload(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
    }

    public void load(String endPoint) {
        String url = ConfigLoader.getInstance().getBaseUrl() + endPoint;
        test.log(Status.INFO, "Navigating to URL: " + url);
        driver.get(url);
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        test.log(Status.INFO, "Waiting for element to be clickable: " + element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBeClickable(By locator) {
        test.log(Status.INFO, "Waiting for element to be clickable: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected Boolean waitForElementToBeInVisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        test.log(Status.INFO, "Typing in text : " + text);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);

    }

    protected void logInfo(String text) {
        test.info(MarkupHelper.createLabel(text, ExtentColor.BLUE));
    }

    protected void type(By locator, String text) {
        test.log(Status.INFO, text);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    public String takeScreenshot() {
        String screenshotName = String.format("Promanage_extent_report_%s.png", DateTimeUtil.getDateTime());
        String imagePath = Paths.get(SCREENSHOTS_DIR, screenshotName).toString();
        String azureFilePath = AZURE_BASE_URL + screenshotName;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File(imagePath));
            byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFile));
            String base64Image = new String(encoded, StandardCharsets.US_ASCII);
            AzureFileUpload.ScreenShot(new File(imagePath));
            Reporter.log(String.format("<a href='%s'> <img src='%s' height='400' width='400'/> </a>", azureFilePath, azureFilePath));
            ExtentManager.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
            return azureFilePath;
        } catch (IOException e) {
            test.log(Status.FAIL, "Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    private void writeToPdf() {
        try {
            PrintsPage printsPage = (PrintsPage) driver;
            PrintOptions options = new PrintOptions();
            Pdf pdf = printsPage.print(options);
            Path pdfPath = Paths.get("./selenium.pdf");
            Files.write(pdfPath, OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
        } catch (IOException | WebDriverException ex) {
            test.log(Status.FAIL, "Failed to write page to PDF: " + ex.getMessage());
        }
    }

    public void dynamicScrolling() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long initialHeight = (long) js.executeScript("return document.body.scrollHeight");
        boolean newContentLoaded;

        do {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrupted during dynamicScrolling: {}", e.getMessage(), e);
                break;
            }

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            newContentLoaded = newHeight > initialHeight;
            initialHeight = newHeight;
        } while (newContentLoaded);
    }

    public void waitForPageLoadToComplete() {
        new DevToolsHelper(driver).waitForPageLoadAndAsyncCompletion();
        String title = driver.getTitle();
        test.log(Status.INFO, "Page title after load: " + title);
    }

    public void waitForElementAndClick(By locator) {
        try {
            fluentWait.until(driver -> {
                WebElement element = driver.findElement(locator);
                element.click();
                return true;
            });
        } catch (TimeoutException e) {
            test.log(Status.INFO, "Failed to click element within timeout: " + locator);
            throw e;
        }
    }

    public void waitForElementAndClickUsingActions(By locator) {
        try {
            fluentWait.until(driver -> {
                WebElement ele = driver.findElement(locator);
                new Actions(driver).moveToElement(ele).click().perform();
                PageLoad.pauseOneSec();
                return ele.isSelected();
            });
        } catch (TimeoutException e) {
            test.log(Status.FAIL, "Failed to click checkbox within timeout: " + locator);
            throw e;
        }
    }

    public void loopUntilElementIsClicked(By locator) throws InterruptedException {
        final int maxAttempts = 30;
        int attempts = 0;
        WebElement element = null;

        while (attempts < maxAttempts) {
            try {
                element = driver.findElement(locator);
                element.click();
                test.log(Status.INFO, "Element clicked: " + locator);
                return;
            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                Thread.sleep(1000);
                attempts++;
            }
        }

        String errorMessage = "Element not found or not clickable within " + maxAttempts + " attempts: " + locator;
        test.log(Status.FAIL, errorMessage);
        throw new NoSuchElementException(errorMessage);
    }

    public void scrollAndClick(By locator) {
        try {
            fluentWait.until(driver -> {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                boolean isVisible = element.isDisplayed() && element.isEnabled();
                if (isVisible) {
                    element.click();
                    return true;
                } else {
                    return false;
                }
            });
        } catch (TimeoutException e) {
            test.log(Status.FAIL, "Failed to scroll and click element within timeout: " + locator);
            throw e;
        }
    }

    public void waitForPageLoaderToDisappear() {
        By loaderLocator = By.cssSelector("div[style*='z-index: 999999']");
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
        } catch (TimeoutException e) {
            test.log(Status.WARNING, "Page loader did not disappear within timeout.");
        }
    }

    public void waitForLoaderToDisappear() {
        By loaderLocator = By.cssSelector("svg.sk-circular");
        try {
            wait.until(driver -> {
                WebElement loader = driver.findElement(loaderLocator);
                boolean isInvisible = !loader.isDisplayed() || "none".equals(loader.getCssValue("display"));
                if (isInvisible) {
                    logger.info("Loader SVG is no longer visible.");
                }
                return isInvisible;
            });
        } catch (TimeoutException e) {
            test.log(Status.WARNING, "Loader SVG did not disappear within timeout.");
        }
    }

    public  void XPathWithJSExecutor(String xpathLocator)  {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // JavaScript to evaluate XPath and return the element
        String script = "return document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;";

        WebElement element = (WebElement) js.executeScript(script);

        if (element != null) {
            js.executeScript("arguments[0].click();", element);
        } else {
            System.out.println("Element not found");
        }
    }

    public  void searchAndSelect(String txt, WebElement element) {

        try {

            String customerName = "Desired Customer";
            int maxRetries = 5;
            int attempt = 0;
            boolean isElementFound = false;

            while (attempt < maxRetries && !isElementFound) {
                try {
                    WebElement customerElement = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@class='sk-overflow-menu']//ul[@class='sk-overflow-list sk-show']/li[. ='"
                                    + customerName + "']")
                    ));

                    customerElement.click();
                    isElementFound = true;
                    System.out.println("Element found and clicked successfully.");

                } catch (TimeoutException e) {
                    System.out.println("Attempt " + (attempt + 1) + ": Element not found. Retrying...");
                    WebElement inputField = driver.findElement(By.id("inputFieldId"));
                    inputField.clear();
                    inputField.sendKeys("Your Input Text");
                    Thread.sleep(1000);
                    attempt++;
                }
            }

            if (!isElementFound) {
                System.out.println("Failed to locate the element after " + maxRetries + " attempts.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void CssWithJSExecutor(String cssSelector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('" + cssSelector + "').scrollIntoView();");
        js.executeScript("document.querySelector('" + cssSelector + "').click();");
    }
}
