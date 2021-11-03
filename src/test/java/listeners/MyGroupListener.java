package listeners;

import org.testng.IClassListener;
import org.testng.ITestClass;

public class MyGroupListener implements IClassListener {
    @Override
    public void onBeforeClass(ITestClass testClass) {
        System.out.println("Test Class before " + testClass.getName());
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        System.out.println("Test Class after " + testClass.getName());
    }
}