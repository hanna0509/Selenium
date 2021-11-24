package ui.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestConfig {
    public static String browser = "chrome";
    public static String headless = "0";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
    @Attachment(type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        byte[] result = null;
        if(driver != null) result =
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return  result;
    }
}
