package ui.UiTests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import ui.pages.SelenideMainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.AppConfig;
import ui.utils.Driver;

import static com.codeborne.selenide.Selenide.open;

public class SmokeTests {
    @BeforeSuite
    public void setUp() {
        Driver.initDriver();
    }

    @BeforeEach
    public void setupTest() {
        open(AppConfig.baseUrl);
      }

    @AfterTest
    public void clearCookies() {
        Driver.clearCookies();
    }

    @Test(description = "Verify that login modal is displayed after clicking login button")
    public static void testLoginButton() {
      open("https://amway.ua");
       SelenideMainPage.loginButtonTest();
    }

    @Test(description = "Test that healthy page is displayed when selecting healthy option on the catalog list")
    public static void testHealthyOption() {
        open("https://amway.ua");
        SelenideMainPage.healthyOptionTest();
    }
}
