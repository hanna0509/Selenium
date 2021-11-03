package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;



public class SelenideTest {

    @Test
    public void testSelenide(){
        Configuration.browser = "edge";
        Configuration.timeout = 100;
        Selenide.open("https://www.amway.ua/");
        Configuration.startMaximized =true;
        SelenideElement LoginButton = $(By.cssSelector("#amweia-app > div.page > header > div > div > div.user-area.user-area--login > div.user-area-login-links.user-area-login-links--desktop > a.user-area-login-links__link.user-area-login-links__link--signin.js-sign-in"))
                .should(Condition.enabled);
        LoginButton.click();

       SelenideElement LoginForm = $(By.id("appContainerDiv"))
              .should(Condition.exist);
        $(By.className("position-2-label"))
                .should(Condition.exist).click();




      //  SelenideElement element = $(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
      //  var selenideElements = $$("asdasd");
    }
}
