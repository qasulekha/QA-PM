package biz.promanage.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtentReportUtility {

        private static ExtentReports extent;
        private static final List<ExtentTest> testList = Collections.synchronizedList(new ArrayList<>());

        public static ExtentReports getReporter() {
            if (extent == null) {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/extentReport.html");
                sparkReporter.config().setTheme(Theme.DARK);
                sparkReporter.config().setDocumentTitle("Test Report");
                sparkReporter.config().setReportName("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }
            return extent;
        }

        public static synchronized ExtentTest startTest(String testName, String description) {
            ExtentTest test = getReporter().createTest(testName, description);
            testList.add(test);
            return test;
        }

        public static List<ExtentTest> getTestList() {
            return new ArrayList<>(testList); // Return a copy to avoid external modification
        }

        public static void flush() {
            extent.flush();
        }
    }


