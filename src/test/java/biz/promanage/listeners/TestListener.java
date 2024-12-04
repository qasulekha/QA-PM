package biz.promanage.listeners;

import biz.promanage.reports.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        String description = result.getMethod().getDescription();
        ExtentManager.startTest(testName, description)
                .assignCategory(getCategory(result))
                .assignAuthor("Borg Joseph");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getLatestTest().ifPresent(test ->
                test.log(Status.SKIP, "Test Skipped: " + getExceptionMessage(result)));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getLatestTest().ifPresent(test ->
                test.log(Status.FAIL, "Test Failed: " + getExceptionMessage(result)));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getLatestTest().ifPresent(test ->
                test.log(Status.PASS, "Test Passed"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        getLatestTest().ifPresent(test ->
                test.log(Status.WARNING, "Test Partially Failed: " + getExceptionMessage(result)));
    }

    @Override
    public void onFinish(ITestContext context) {
        List<ExtentTest> nonSkippedTests = ExtentManager.getTestList().stream()
                .filter(test -> test.getStatus() != Status.SKIP)
                .toList();

        ExtentManager.getTestList().clear();
        nonSkippedTests.forEach(test -> ExtentManager.getReporter().createTest(String.valueOf(test.getModel())));

        ExtentManager.flushReport();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    private Optional<ExtentTest> getLatestTest() {
        List<ExtentTest> testList = ExtentManager.getTestList();
        return testList.isEmpty() ? Optional.empty() : Optional.of(testList.get(testList.size() - 1));
    }

    private String getCategory(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        return groups.length > 0 ? String.join(", ", groups) : "Uncategorized";
    }

    private String getExceptionMessage(ITestResult result) {
        Throwable throwable = result.getThrowable();
        return (throwable != null) ? throwable.getMessage() : "No exception information available.";
    }
}
