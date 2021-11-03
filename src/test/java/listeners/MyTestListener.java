package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDate;

public class MyTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName());
        System.out.println("Test started time -> "+ LocalDate.now());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success with result " + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed with result " + result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        context.setAttribute("name", " name");
        System.out.println(context.getAllTestMethods().length);
        System.out.println("Test Finished time -> "+ LocalDate.now());
    }
}
