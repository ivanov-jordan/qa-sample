package test.selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.selenium.sample.utils.WebDriverFactory;
import test.selenium.sample.utils.WebDriverType;

public class AbvTest {

    private final static WebDriverType DRIVER_TYPE = WebDriverType.CHROME;

    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        webDriver = WebDriverFactory.getInstance(DRIVER_TYPE);
    }

    @After
    public void tearDown() throws Exception {
        webDriver.quit();
    }

    @Test
    public void testAbvVisibility() throws Exception {
        webDriver.get("http://abv.bg");

        WebElement username = webDriver.findElement(By.xpath("//input[@id = 'username']"));
        WebElement password = webDriver.findElement(By.xpath("//input[@id = 'password']"));
        WebElement loginButton = webDriver.findElement(By.xpath("//input[@id = 'loginBut']"));

        username.sendKeys("test");
        password.sendKeys("123");
        loginButton.click();

        try {
            webDriver.findElement(By.xpath("//p[@id = 'form.errors']"));
        } catch (NoSuchElementException nsee) {
            Assert.fail("Error message is not found on page");
        }
    }

}
