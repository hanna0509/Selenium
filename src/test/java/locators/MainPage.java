package locators;

import com.codeborne.selenide.selector.ByText;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage extends BasePage {
    @FindBy(linkText = "Увійти")
    private WebElement loginButton;
    @FindBy(css = "#amweia-app > div.page > header > div > div > div.site-search > div.site-search-desktop > div > div > form > div > div.search-autocomplete.search-autocomplete--search-btn-right > div > input")
    private WebElement searchField;
    @FindBy(css = "#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a")
    private WebElement catalogMenuButton;
    @FindBy(css = "ul > li a.main-category-link")
    private WebElement healthyOption;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void startLogIn() {
        loginButton.click();
        var pageTitle = driver.getTitle();
        Assertions.assertEquals("Amway - офіційний сайт та інтернет-магазин компанії", pageTitle);
    }

    public void searchField(String searchWord, String searchResult) {
        searchField.sendKeys(searchWord);
        Assert.assertEquals(driver.findElement(By.className("search-autocomplete-results__title")).getText(), searchResult);
    }

    public void catalogMenuButton() {
        catalogMenuButton.click();
        var catalogMenu = new WebDriverWait(driver, 10);
        catalogMenu.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.cssSelector("ul > li picture")).isDisplayed();
            }
        });
    }

    public void healthyOption() {
        healthyOption.click();
        var healthyPage = new WebDriverWait(driver, 10);
        healthyPage.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                return driver.findElement(new ByText("Вітаміни Nutrilite™: придбати за вигідними цінами на офіційному сайті Amway в Україні - стр. 1"));
            }
        });
    }

}
