package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reporting.ExtentReportUtil;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        ExtentReportUtil.createTest(result.getName());
    }
    @Override public void onTestStart(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        ExtentReportUtil.createTest(result.getName());
    }
    @Override public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        ExtentReportUtil.createTest(result.getName());
    }
    @Override public void onStart(ITestContext context) {
        System.out.println("Test started: " + context.getName());
        ExtentReportUtil.createTest(context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished: " + context.getName());
        ExtentReportUtil.createTest(context.getName());
    }
}