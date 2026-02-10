package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.testng.annotations.*;
import java.net.URI;
import static org.testng.Assert.assertEquals;

public class Activity3 {

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

        driver.get("https://training-support.net/webelements/todo-list");
    }

    @Test
    public void todoListTest() {
        driver.findElement(AppiumBy.id("todo-input")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.id("todo-add")).click();

        driver.findElement(AppiumBy.id("todo-input")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.id("todo-add")).click();

        driver.findElement(AppiumBy.id("todo-input")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.id("todo-add")).click();

        int count = driver.findElements(AppiumBy.className("todo-item")).size();
        assertEquals(count, 5); // 2 existing + 3 added
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
