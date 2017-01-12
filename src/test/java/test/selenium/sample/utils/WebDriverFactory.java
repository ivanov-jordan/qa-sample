package test.selenium.sample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getInstance(WebDriverType webDriverType) {
        WebDriver driver = null;

        System.setProperty(webDriverType.getSystemProperty(), webDriverType.getPathToDriver());

        switch (webDriverType) {
        case FIREFOX:
            driver = new FirefoxDriver();
            break;
        default:
            driver = new ChromeDriver();
            break;
        }

        return driver;
    }

}
