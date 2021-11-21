import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import locators.SelenideCartPage;
import locators.SelenideLoginPage;
import locators.SelenideMainPage;
import locators.SelenideZdoroviaPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Callable;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class SelenideTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 100;
        Configuration.headless = false;
    }
    @Test
    public static void addProductToTheCart(){
        open("https://www.amway.ua/zdorovia/c/10003#!filter?page=1");
        SelenideZdoroviaPage.contOfProducts("48 з 72");
        SelenideZdoroviaPage.addToCart();
        SelenideCartPage.verifyCartItem("2", "2 846 грн", "2 846 грн");
         }

    @Test
    public static void testInvalidLogin() {

       open("https://account.amwayglobal.com/uk-ua/?fromURI=https:%2F%2Fidp.amwayglobal.com%2Fapp%2Famwayconnect_hybrisukrainewww_1%2FexkhemyokdadXy3Xb1t7%2Fsso%2Fsaml%3Fclientapp%3DHybrisWebsiteUA%26lng%3Duk-ua%26cancelredirect%3Dhttps%253A%252F%252Fwww.amway.ua%252Fuk%252Fsinglesignon%252Fsignin_cancelled");
        SelenideLoginPage.logIn("user","password");
    }

    @Test
    public static void testLoginButton() {
        open("https://amway.ua");
        SelenideMainPage.loginButtonTest();
    }

    @Test
    public static void testHealthyOption() {
        open("https://amway.ua");
        SelenideMainPage.healthyOptionTest();
    }

    @Test
    public static void testCatalogMenu() {
        open("https://amway.ua");
        SelenideMainPage.catalogMenu();
    }

    @Test
    public static void testSearchField() {
        open("https://amway.ua");
        SelenideMainPage.searchFieldTest("Art","Переглянути все 142 результат");
    }
        }



