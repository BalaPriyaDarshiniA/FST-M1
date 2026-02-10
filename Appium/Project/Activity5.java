package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.testng.annotations.*;
import java.net.URI;
import static org.testng.Assert.assertTrue;

public class Activity5 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        driver = new AndroidDriver(
                new URI("http://localhost:4723").toURL(), options);

        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    public void validLogin() {
        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//button[text()='Submit']")).click();

        assertTrue(driver.findElement(
                AppiumBy.xpath("//*[contains(text(),'Welcome')]")).isDisplayed());
    }

    @Test
    public void invalidLogin() {
        driver.findElement(AppiumBy.id("username")).clear();
        driver.findElement(AppiumBy.id("password")).clear();

        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("wrongpass");
        driver.findElement(AppiumBy.xpath("//button[text()='Submit']")).click();

        assertTrue(driver.findElement(
                AppiumBy.xpath("//*[contains(text(),'Invalid')]")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
