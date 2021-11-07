import com.codeborne.selenide.*;
import locators.SelenideLoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class SelenideTest {
    @Test
    public static void testSelenide(){
        Configuration.browser = "edge";
        Configuration.timeout = 100;
        Configuration.headless = false;
        open("https://www.amway.ua/zdorovia/c/10003#!filter?page=1");
        SelenideElement countOfHealthyProducts = $(By.cssSelector("div.product-viewer__viewing>div>b"))
                .should(visible);
        countOfHealthyProducts.should(Condition.exactText("48 з 72"));

    }
    @Test
    public static void testInvalidLogin() {
       Configuration.browser = "chrome";
       Configuration.startMaximized = true;
       Configuration.headless = false;
       open("https://account.amwayglobal.com/uk-ua/?fromURI=https:%2F%2Fidp.amwayglobal.com%2Fapp%2Famwayconnect_hybrisukrainewww_1%2FexkhemyokdadXy3Xb1t7%2Fsso%2Fsaml%3Fclientapp%3DHybrisWebsiteUA%26lng%3Duk-ua%26cancelredirect%3Dhttps%253A%252F%252Fwww.amway.ua%252Fuk%252Fsinglesignon%252Fsignin_cancelled");
        SelenideLoginPage.logIn("user","password");






    }
        }



