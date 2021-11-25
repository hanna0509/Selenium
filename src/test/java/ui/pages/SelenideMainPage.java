package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenideMainPage {
    static By loginButton = By.xpath("/html/body/main/div[1]/header/div/div/div[3]/div[1]/a[1]");
    static By searchField = By.cssSelector("#amweia-app > div.page > header > div > div > div.site-search > div.site-search-desktop > div > div > form > div > div.search-autocomplete.search-autocomplete--search-btn-right > div > input");
    static By catalogMenuButton = By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a");
    static By healthyOption = By.cssSelector("ul > li a.main-category-link");
    static By searchButton = (By.className("search-autocomplete__search-btn"));
    static By catalogList = By.cssSelector("ul > li picture");
    static By healthyPageTitle = new ByText("Вітаміни Nutrilite™: придбати за вигідними цінами на офіційному сайті Amway в Україні - стр. 1");
    static By submitButton = By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button");

    public static WebElement searchFieldTest(String searchWord, String searchResult) {
        $(searchField).sendKeys(searchWord);
        $(searchButton).should(Condition.visible, Duration.ofSeconds(20)).click();
        return
                $("h3", 1).shouldHave(text(searchResult), Duration.ofSeconds(20));
    }

    public static boolean catalogMenu() {
        $(catalogMenuButton).click();
        return
                $(catalogList).isDisplayed();
    }

    public static boolean healthyOptionTest() {
        $(catalogMenuButton).click();
        $(healthyOption).click();
        return
                $(healthyPageTitle).isDisplayed();
    }

    public static WebElement loginButtonTest() {
        $(loginButton).click();
        $(submitButton).should(Condition.visible, Duration.ofSeconds(20));


        return
                $(submitButton).should(text("УВІЙТИ"));
    }
}
