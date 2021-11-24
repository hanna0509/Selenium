package ui.UiTests;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import ui.pages.SelenideLoginPage;
import ui.pages.SelenideMainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.AppConfig;
import ui.utils.Driver;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RegressionTests {
    @BeforeSuite
    public void setUp() {
        Driver.initDriver();
    }

    @BeforeTest
    public void setupTest() {
        open(AppConfig.baseUrl);
    }

    @AfterTest
    public void clearCookies() {
        Driver.clearCookies();
    }

    @Test(description = "Verify that error message is displayed when filling invalid login or password")
    public static void testInvalidLogin() {
        open ("https://account.amwayglobal.com/uk-ua/?fromURI=https:%2F%2Fidp.amwayglobal.com%2Fapp%2Famwayconnect_hybrisukrainewww_1%2FexkhemyokdadXy3Xb1t7%2Fsso%2Fsaml%3Fclientapp%3DHybrisWebsiteUA%26lng%3Duk-ua%26cancelredirect%3Dhttps%253A%252F%252Fwww.amway.ua%252Fuk%252Fsinglesignon%252Fsignin_cancelled");
        SelenideLoginPage.logIn("user", "password");
    }

    @Test(description = "Test catalog list is displayed after clicking catalog menu button")
    public static void testCatalogMenu() {
        open("https://amway.ua");
        SelenideMainPage.catalogMenu();
    }

    @Test(description = "Test search by 3 characters")
    public static void testSearchField() {
        open("https://amway.ua");
        SelenideMainPage.searchFieldTest("Art", "142 знайдених результатів для Art");
    }


    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
