package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7_ReadPopup {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Leads")).click();

        driver.findElement(By.cssSelector("span.additional-info")).click();
        Thread.sleep(2000);

        String phone = driver.findElement(By.className("phone")).getText();
        System.out.println("Phone Number: " + phone);

        driver.quit();
    }
}
