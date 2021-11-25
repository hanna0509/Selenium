package ui.UiTests;

import org.testng.annotations.AfterTest;
import ui.pages.SelenideCartPage;
import ui.pages.SelenideZdoroviaPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.AppConfig;
import ui.utils.Driver;

import static com.codeborne.selenide.Selenide.open;

public class CartTest {
    @BeforeTest
    public void setUp() {
        Driver.initDriver();
        open(AppConfig.baseUrl);
    }

    @AfterTest
    public void clearCookies() {
        Driver.clearCookies();
    }

    @Test(description = "Test that product is added to the cart and costs as expected")
    public static void addProductToTheCart() {
        open("https://www.amway.ua/zdorovia/c/10003#!filter?page=1");
        SelenideZdoroviaPage.contOfProducts("48 з 72");
        SelenideZdoroviaPage.addToCart();
        SelenideCartPage.verifyCartItem("2", "4 566 грн", "4 566 грн");
    }
}
