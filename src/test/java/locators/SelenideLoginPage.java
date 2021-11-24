package locators;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenideLoginPage {
    static By loginTab = By.className("position-2-label");
    static By loginField = By.id("username");
    static By passwordField = By.id("password");
    static By submitButton = By.xpath("/html/body/div/div[2]/div/app-root/div/div[1]/div/app-signin/div/div/div/div/div/div/app-button/button");
    static By alertMessage = By.className("alert-message");

    public static WebElement logIn(String login, String pass) {
        Configuration.timeout = 200;
        $(loginTab).should(Condition.visible).click();
        $(loginField).should(Condition.visible).sendKeys(login);
        $(passwordField).sendKeys(pass);
        $(submitButton).click();
        $(alertMessage).shouldBe(Condition.visible, Duration.ofSeconds(30));
        return
                $(alertMessage).shouldHave(text("Комбінація вашого Amway ID та паролю не відповідає нашим даним. Будь ласка, спробуйте ще раз."));
    }
}
