import locators.LogInPage;
import locators.MainPage;
import org.junit.jupiter.api.AfterEach;
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
    public void invalidLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.startLogIn();
        LogInPage loginPage = new LogInPage(driver);
        loginPage.logIn("Test_User", "Password");
    }
    @AfterEach
    public void endTest() {
        driver.close();
    }

    @Test
    public void searchFieldTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchField("Artistry", "Продукція");
    }

    @Test
    public void catalogMenuButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.catalogMenuButton();
    }

    @Test
    public void catalogMenuHealthyOptionTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.catalogMenuButton();
        mainPage.healthyOption();
    }
}
