import com.codeborne.selenide.selector.ByText;
import org.apache.tools.ant.types.Assertions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LocatorsHWTest {

    @Test

    public void incorrectLoginTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement LoginButton = driver.findElement(By.cssSelector("#amweia-app > div.page > header > div > div > div.user-area.user-area--login > div.user-area-login-links.user-area-login-links--desktop > a.user-area-login-links__link.user-area-login-links__link--signin.js-sign-in"));
        LoginButton.click();

        WebElement LoginTab = driver.findElement(By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-id-toggle/div/div/div[1]/label[2]"));
        LoginTab.click();

        WebElement LoginField = driver.findElement(By.id("username"));
        LoginField.sendKeys("TestUser");

        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.click();
        PasswordField.sendKeys("password1");

        WebElement SubmitButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button"));
        SubmitButton.click();

        var alertMessage = new WebDriverWait(driver, 10);
        alertMessage.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.className("alert-message")).isDisplayed();
            }
        });
        driver.close();
    }

    @Test

    public void catalogButtonTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement catalogMenuButton = driver.findElement(By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a"));
        catalogMenuButton.click();

        var catalogMenu = new WebDriverWait(driver, 10);
        catalogMenu.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.cssSelector("ul > li picture")).isDisplayed();
            }
        });
        driver.close();
    }

    @Test

    public void catalogMenuHealthyOptionTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement catalogMenuButton = driver.findElement(By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a"));
        catalogMenuButton.click();

        WebElement healthyOption = driver.findElement(By.cssSelector("ul > li a.main-category-link"));
        healthyOption.click();

        var healthyPage = new WebDriverWait(driver, 10);
        healthyPage.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                return driver.findElement(new ByText("Вітаміни Nutrilite™: придбати за вигідними цінами на офіційному сайті Amway в Україні - стр. 1"));
            }
        });
        driver.close();
    }

    @Test

    public void countOfProductsDisplay() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        WebElement catalogMenuButton = driver.findElement(By.cssSelector("#amweia-app > div.page > nav > div > div > ul:nth-child(1) > li:nth-child(1) > a"));
        catalogMenuButton.click();

        WebElement healthyOption = driver.findElement(By.cssSelector("ul > li a.main-category-link"));
        healthyOption.click();

        var healthyPage = new WebDriverWait(driver, 10);
        healthyPage.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                return driver.findElement(new ByText("Вітаміни Nutrilite™: придбати за вигідними цінами на офіційному сайті Amway в Україні - стр. 1"));
            }
        });

        WebElement countOfHealthyProducts = driver.findElement(By.cssSelector("div.product-viewer__viewing>div>b"));
        Assert.assertEquals(countOfHealthyProducts.getText(), "48 з 73");
        driver.close();
    }

    @Test
    public void searchFieldTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        WebElement searchField = driver.findElement(By.cssSelector("#amweia-app > div.page > header > div > div > div.site-search > div.site-search-desktop > div > div > form > div > div.search-autocomplete.search-autocomplete--search-btn-right > div > input"));
        searchField.sendKeys("Artistry");
        Assert.assertEquals(driver.findElement(By.className("search-autocomplete-results__title")).getText(), "Продукція");
        driver.close();
    }
}
