package biz.promanage.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ExtentManager {
    private static final Map<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();
    private static final List<ExtentTest> allTests = Collections.synchronizedList(new ArrayList<>());
    private static volatile ExtentReports extent;

    private static final String DIR_NAME = "./reports/";
    private static final String TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
   // private static final String FILE_NAME = "Promanage_Sanity_Report_" + TIMESTAMP + ".html";
    private static final String FILE_NAME = "Promanage_Sanity_Report" + ".html";
    private static final String REPORT_DISPLAY_NAME = "Promanage Sanity Report";

    private ExtentManager() { }

    public static ExtentReports getInstance() {
        if (extent == null) {
            synchronized (ExtentManager.class) {
                if (extent == null) {
                    String reportPath = Paths.get(DIR_NAME, FILE_NAME).toString();
                    initializeExtentReports(reportPath);
                }
            }
        }
        return extent;
    }

    private static void initializeExtentReports(String reportPath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle(REPORT_DISPLAY_NAME);
        sparkReporter.config().setReportName(REPORT_DISPLAY_NAME);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("UTF-8");
        sparkReporter.config().setCss(
                ".pass-bg{background-color:#649131;letter-spacing:1px!important;padding:4px!important}" +
                        ".fail-bg{letter-spacing:1px!important;padding:4px!important}" +
                        ".text-pass{color:#c6def1 !important}" +
                        ".badge-success{background-color:#649131 !important}" +
                        ".badge-danger{background-color:#649131 !important}"
        );

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Author", "Borg Joseph");
        extent.setSystemInfo("Organization", "Sulekha");
        extent.setSystemInfo("Build no", "1.0");
    }

    public static ExtentReports getReporter() {
        return getInstance();
    }

    public static ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest test = getReporter().createTest(convertCamelCaseToSpaces(testName), description);
        extentTestMap.put(Thread.currentThread().getId(), test);
        allTests.add(test);
        return test;
    }

    public static synchronized void flushReport() {
        List<ExtentTest> nonSkippedTests = allTests.stream()
                .filter(test -> test.getStatus() != Status.SKIP)
                .collect(Collectors.toList());

        allTests.clear();
        allTests.addAll(nonSkippedTests);

        extent.flush();
    }

    public static String convertCamelCaseToSpaces(String camelCaseString) {
        if (camelCaseString == null || camelCaseString.isEmpty()) {
            return camelCaseString;
        }
        String[] words = camelCaseString.split("(?=[A-Z])");
        return String.join(" ", Arrays.stream(words)
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .toArray(String[]::new));
    }

    public static List<ExtentTest> getTestList() {
        return new ArrayList<>(allTests);
    }
}
