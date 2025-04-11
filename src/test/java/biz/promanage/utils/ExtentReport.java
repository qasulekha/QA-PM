package biz.promanage.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static Date d = new Date();
    static String dirName = ".\\reports\\";
    //static String fileName =  "Promanage_Sanity_Report" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String fileName =  "Promanage_Sanity_Report" + ".html";
    static String reportDisplayName =  "Promanage Sanity Report" ;
    static String path = dirName + fileName;
    public synchronized static ExtentReports getReporter() {

        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
            htmlReporter.config().setDocumentTitle("Promanage Sanity Report");
            htmlReporter.config().setReportName(reportDisplayName);
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setEncoding("UTF-8");
            htmlReporter.config().setCss(".pass-bg{background-color:#649131;letter-spacing:1px!important;padding:4px!important} .fail-bg{letter-spacing:1px!important;padding:4px!important} .text-pass{color:#c6def1 !important} .badge-success{background-color:#649131 !important} .badge-danger{background-color:#649131 !important}");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.getStats();
            extent.setSystemInfo("Author", "Borg Joseph");
            extent.setSystemInfo("Organization", "Sulekha");
            extent.setSystemInfo("Build no", "1.0");
        }

        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName.replace('_', ' '), desc);
        extentTestMap.put((int) (Thread.currentThread().getId()), test);
        return test;
    }
}
