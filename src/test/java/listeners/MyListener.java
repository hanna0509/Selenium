package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.time.LocalDate;

public class MyListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println(suite.getName());
        System.out.println("Suite started time -> "+ LocalDate.now());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(suite.getName());
        System.out.println("Suite ended time -> "+ LocalDate.now());
    }
}