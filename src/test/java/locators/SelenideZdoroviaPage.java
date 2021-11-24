package locators;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelenideZdoroviaPage {
    static By countOfHealthyProducts = By.cssSelector("div.product-viewer__viewing>div>b");
    static By cookieMessageClose = By.className("disclaimer__button");
    static By selectProduct = By.partialLinkText("Набір \"Імунітет\"");
    static By addToCartButton = By.id("autotest-add-to-cart-button");
    static By cartIconButton = By.className("header__cart-icon");
    static By cartPage = By.cssSelector("h2");

    public static boolean contOfProducts(String text) {
        Configuration.timeout = 200;
        $(countOfHealthyProducts).should(visible).should(Condition.exactText(text));
        return true;
    }

    public static WebElement addToCart() {
        $(cookieMessageClose).click();
        $(selectProduct).should(enabled).hover().click();
        $(addToCartButton).click();
        $(addToCartButton).click();
        $(cartIconButton).click();
        return
                $(cartPage).should(Condition.text("Кошик"), Duration.ofSeconds(10));
    }
}
