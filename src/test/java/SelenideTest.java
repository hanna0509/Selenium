import com.codeborne.selenide.*;
import locators.SelenideCartPage;
import locators.SelenideLoginPage;
import locators.SelenideMainPage;
import locators.SelenideZdoroviaPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 100;
        Configuration.headless = false;
    }

    @Test
    public static void addProductToTheCart() {
        open("https://www.amway.ua/zdorovia/c/10003#!filter?page=1");
        SelenideZdoroviaPage.contOfProducts("48 з 72");
        SelenideZdoroviaPage.addToCart();
        SelenideCartPage.verifyCartItem("2", "2 846 грн", "2 846 грн");
    }

    @Test(description = "Verify that error message is displayed when filling invalid login or password")
    public static void testInvalidLogin() {
        open("https://account.amwayglobal.com/uk-ua/?fromURI=https:%2F%2Fidp.amwayglobal.com%2Fapp%2Famwayconnect_hybrisukrainewww_1%2FexkhemyokdadXy3Xb1t7%2Fsso%2Fsaml%3Fclientapp%3DHybrisWebsiteUA%26lng%3Duk-ua%26cancelredirect%3Dhttps%253A%252F%252Fwww.amway.ua%252Fuk%252Fsinglesignon%252Fsignin_cancelled");
        SelenideLoginPage.logIn("user", "password");
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
}



