package locators;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebElement loginButton;
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
        this.loginButton = driver.findElement(By.linkText("Увійти"));
    }

    public void startLogIn() {
        loginButton.click();
        var pageTitle = driver.getTitle();
        Assertions.assertEquals("Amway - офіційний сайт та інтернет-магазин компанії", pageTitle);
    }
}
