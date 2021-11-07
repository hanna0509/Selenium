package locators;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(className = "position-2-label")
    private WebElement loginTab;
    @FindBy(id = "username")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button")
    private WebElement submitButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String login, String password) {
        this.loginTab.click();
  //      this.loginField = driver.findElement(By.id("username"));
        this.loginField.sendKeys(login);
        this.passwordField.sendKeys(password);
 //       this.submitButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button"));
        this.submitButton.click();
        var alertMessage = driver.findElement(By.className("alert-message"));
        Assertions.assertEquals("Комбінація вашого Amway ID та паролю не відповідає нашим даним. Будь ласка, спробуйте ще раз.", alertMessage.getText());
    }
}