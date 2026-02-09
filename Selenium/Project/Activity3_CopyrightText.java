package crm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3_CopyrightText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        String text = driver.findElement(By.id("admin_options")).getText();
        System.out.println(text);

        driver.quit();
    }
}
