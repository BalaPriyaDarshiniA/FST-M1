package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6_MenuCheck {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        boolean exists = driver.findElement(By.linkText("Activities")).isDisplayed();
        System.out.println("Activities menu exists: " + exists);

        driver.quit();
    }
}
