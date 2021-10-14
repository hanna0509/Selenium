import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LocatorsHWTest {

    @Test

    public void LocatorsHWTest() {
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
        var waiter = new WebDriverWait(driver, 10);
        waiter.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.className("alert-message")).isDisplayed();
            }
        });
        driver.close();
    }
}
