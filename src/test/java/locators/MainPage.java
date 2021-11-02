package locators;

import com.codeborne.selenide.selector.ByText;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {

    private WebElement loginButton;
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement searchField;
    private WebElement catalogMenuButton;
    private WebElement healthyOption;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
        this.loginButton = driver.findElement(By.linkText("Увійти"));
        this.searchField = driver.findElement(By.cssSelector("#amweia-app > div.page > header > div > div > div.site-search > div.site-search-desktop > div > div > form > div > div.search-autocomplete.search-autocomplete--search-btn-right > div > input"));
        this.catalogMenuButton = driver.findElement(By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a"));
        this.healthyOption = driver.findElement(By.cssSelector("ul > li a.main-category-link"));
    }

    public void startLogIn() {
        loginButton.click();
        var pageTitle = driver.getTitle();
        Assertions.assertEquals("Amway - офіційний сайт та інтернет-магазин компанії", pageTitle);
    }

    public void searchField(String searchWord,String searchResult) {
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
    public void healthyOption(){
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
