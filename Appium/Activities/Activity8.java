package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.URI;
import java.time.Duration;
import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Activity8 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);

        driver.get("https://training-support.net/webelements");
    }

    // -------- TAP GESTURE --------
    @Test(priority = 1)
    public void tapGesture() {
        WebElement button = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Buttons']"));

        tap(getElementCenter(button));
        assertTrue(button.isDisplayed());
    }

    // -------- LONG PRESS GESTURE --------
    @Test(priority = 2)
    public void longPressGesture() {
        WebElement element = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Buttons']"));

        longPress(getElementCenter(element), 1500);
        assertTrue(element.isDisplayed());
    }

    // -------- SWIPE GESTURE --------
    @Test(priority = 3)
    public void swipeGesture() {
        Dimension dims = driver.manage().window().getSize();

        Point start = new Point(dims.width / 2, (int) (dims.height * 0.8));
        Point end = new Point(dims.width / 2, (int) (dims.height * 0.3));

        swipe(start, end, 1000);
        assertTrue(true);
    }

    // -------- SCROLL GESTURE --------
    @Test(priority = 4)
    public void scrollGesture() {
        swipe(
                new Point(500, 1600),
                new Point(500, 600),
                1000
        );
        assertTrue(true);
    }

    // -------- PINCH / ZOOM GESTURE --------
    @Test(priority = 5)
    public void pinchZoomGesture() {
        Dimension dims = driver.manage().window().getSize();
        Point center = new Point(dims.width / 2, dims.height / 2);

        zoom(center);
        assertTrue(true);
    }

    // ---------------- HELPER METHODS ----------------

    public Point getElementCenter(WebElement element) {
        int x = element.getRect().getX() + element.getRect().getWidth() / 2;
        int y = element.getRect().getY() + element.getRect().getHeight() / 2;
        return new Point(x, y);
    }

    public void tap(Point point) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                point.x,
                point.y
        ));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
    }

    public void longPress(Point point, int duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence press = new Sequence(finger, 1);

        press.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                point.x,
                point.y
        ));
        press.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        press.addAction(finger.createPointerMove(
                Duration.ofMillis(duration),
                PointerInput.Origin.viewport(),
                point.x,
                point.y
        ));
        press.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(press));
    }

    public void swipe(Point start, Point end, int duration) {
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

    public void zoom(Point center) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence zoom1 = new Sequence(finger1, 1);
        Sequence zoom2 = new Sequence(finger2, 1);

        zoom1.addAction(finger1.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                center.x,
                center.y
        ));
        zoom1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        zoom1.addAction(finger1.createPointerMove(
                Duration.ofMillis(500),
                PointerInput.Origin.viewport(),
                center.x - 200,
                center.y - 200
        ));
        zoom1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        zoom2.addAction(finger2.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                center.x,
                center.y
        ));
        zoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        zoom2.addAction(finger2.createPointerMove(
                Duration.ofMillis(500),
                PointerInput.Origin.viewport(),
                center.x + 200,
                center.y + 200
        ));
        zoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(zoom1, zoom2));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
