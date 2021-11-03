import listeners.MyGroupListener;
import listeners.MyListener;
import listeners.MyTestListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({MyTestListener.class, MyListener.class, MyGroupListener.class})
public class ListenersTest{

    @Test
    public void locatorsHWTest() {
        System.out.println("TEST ---------");
    }
}