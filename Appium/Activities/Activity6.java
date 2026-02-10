package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Appium Server URL
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Initialize driver
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the slider page
        driver.get("https://training-support.net/webelements/sliders");
    }

    @Test
    public void volume75Test() {
        // Wait for slider
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension dims = driver.manage().window().getSize();

        Point start = new Point((int) (dims.getWidth() * 0.50), (int) (dims.getHeight() * 0.77));
        Point end = new Point((int) (dims.getWidth() * 0.67), (int) (dims.getHeight() * 0.77));

        doSwipe(start, end, 1000);

        String volumeText = driver.findElement(
                AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text,'%')]"))
                .getText();

        assertTrue(volumeText.contains("75%"));
    }

    @Test
    public void volume25Test() {
        // Wait for slider
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension dims = driver.manage().window().getSize();

        Point start = new Point((int) (dims.getWidth() * 0.50), (int) (dims.getHeight() * 0.77));
        Point end = new Point((int) (dims.getWidth() * 0.33), (int) (dims.getHeight() * 0.77));

        doSwipe(start, end, 1000);

        String volumeText = driver.findElement(
                AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text,'%')]"))
                .getText();

        assertTrue(volumeText.contains("25%"));
    }

    // Swipe method using W3C Actions (Appium 2 compatible)
    public void doSwipe(Point start, Point end, int duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                start.x,
                start.y
        ));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(duration),
                PointerInput.Origin.viewport(),
                end.x,
                end.y
        ));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
