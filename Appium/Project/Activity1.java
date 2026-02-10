package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.testng.annotations.*;

import java.net.URI;
import static org.testng.Assert.assertTrue;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity("com.google.android.apps.tasks.ui.TaskListsActivity");
        options.noReset();

        driver = new AndroidDriver(
                new URI("http://localhost:4723").toURL(), options);
    }

    @Test
    public void createTasks() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity 1");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity 2");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity 3");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        assertTrue(driver.findElement(
                AppiumBy.xpath("//*[@text='Complete Activity 1']")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
