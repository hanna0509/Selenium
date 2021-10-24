import locators.LogInPage;
import locators.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class PageObjectTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void selectItemtest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.startLogIn();
        LogInPage loginPage = new LogInPage(driver);
        loginPage.logIn("Test_User", "Password");
    }
}
