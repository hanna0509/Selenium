import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FindImage {
    @Test

    public void findImage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amway.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        var ListElements = driver.findElements(By.tagName("img"));
        driver.findElement(By.linkText("Детальніше")).click();

        var waiter = new WebDriverWait(driver, 10);
        waiter.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.className("footer-disclimer__logo")).isDisplayed();
            }
        });
        System.out.println(ListElements);
        driver.close();
    }
}
