package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.testng.annotations.*;
import java.net.URI;
import static org.testng.Assert.assertTrue;

public class Activity4 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        driver = new AndroidDriver(
                new URI("http://localhost:4723").toURL(), options);
    }

    @Test
    public void addNoteWithReminder() {
        driver.findElement(AppiumBy.id("new_note_button")).click();
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Reminder Note");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("This has a reminder");

        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        driver.findElement(AppiumBy.xpath("//*[@text='Tomorrow morning']")).click();

        driver.navigate().back();
        assertTrue(driver.findElement(
                AppiumBy.xpath("//*[@text='Reminder Note']")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
