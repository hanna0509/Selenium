package locators;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement loginTab;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement submitButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
        this.loginTab = driver.findElement(By.className("position-2-label"));
        this.loginField = driver.findElement(By.id("username"));
        this.passwordField = driver.findElement(By.id("password"));
        this.submitButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button"));
    }

    public void logIn(String login, String password) {
        loginTab.click();
        this.loginField = driver.findElement(By.id("username"));
        loginField.sendKeys(login);
        this.passwordField.sendKeys(password);
        this.submitButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button"));
        submitButton.click();
        var alertMessage = driver.findElement(By.className("alert-message"));
        Assertions.assertEquals("Комбінація вашого Amway ID та паролю не відповідає нашим даним. Будь ласка, спробуйте ще раз.", alertMessage.getText());
    }
}