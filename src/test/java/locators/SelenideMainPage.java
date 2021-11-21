package locators;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class SelenideMainPage {
    static By loginButton = By.linkText("Увійти");
    static By searchField = By.cssSelector("#amweia-app > div.page > header > div > div > div.site-search > div.site-search-desktop > div > div > form > div > div.search-autocomplete.search-autocomplete--search-btn-right > div > input");
    static By catalogMenuButton = By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a");
    static By healthyOption = By.cssSelector("ul > li a.main-category-link");
    static By searchResultTitle = By.partialLinkText("Переглянути все");
    static By catalogList = By.cssSelector("ul > li picture");
    static By healthyPageTitle = new ByText("Вітаміни Nutrilite™: придбати за вигідними цінами на офіційному сайті Amway в Україні - стр. 1");
    static By loginModalTitle = By.cssSelector("h1");

    public static <searchResult> WebElement searchFieldTest(String searchWord, String searchResult){
        $(searchField).sendKeys(searchWord);
        return
                $(searchResultTitle).should(Condition.text(searchResult));
    }

    public static boolean catalogMenu(){
        $(catalogMenuButton).click();
        return
                $(catalogList).isDisplayed();
    }

    public static boolean healthyOptionTest(){
        $(catalogMenuButton).click();
        $(healthyOption).click();
        return
                $(healthyPageTitle).isDisplayed();
    }

    public static WebElement loginButtonTest(){
        $(loginButton).click();
        return
                $(loginModalTitle).should(Condition.text("Увійти"));
    }

}
