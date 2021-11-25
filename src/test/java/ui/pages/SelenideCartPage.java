package ui.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SelenideCartPage {
    static By countAddedItems = By.cssSelector("#amweia-app > div.page > div.cart__wrapper > div.cart__slot--1 > div:nth-child(1) > div > div.container.cart__container > div > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div > div.sub-cart-totals---root---1-NDa_0 > div.item-list__item-wrapper.item-list__item-wrapper--for-cart-total > div.cart__total.sub-cart-totals---cartTotal---RjpYV_0 > div > span.cart__total-qty");
    static By cartTitle = By.cssSelector(".cart__total-title");
    static By cartTotalPrice = By.cssSelector(".cart__total-total");
    static By grandCartTotalLabel = By.cssSelector(".cart-totals---grandTotalLabel---OjB_i_0");
    static By grandCartTotalValue = By.cssSelector(".cart-totals---grandTotalValue---3q5N8_0");

    public static boolean verifyCartItem(String countItems, String price, String totalValue) {
        $(countAddedItems).shouldHave(Condition.text(countItems));
        $(cartTitle).should(Condition.text("Огляд кошика"), Duration.ofSeconds(20));
        $(cartTotalPrice).should(Condition.text(price));
        $(grandCartTotalLabel).should(Condition.text("До сплати"));
        $(grandCartTotalValue).should(Condition.text(totalValue));
        return true;
    }
}
