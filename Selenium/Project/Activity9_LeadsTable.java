package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class Activity9_LeadsTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Leads")).click();

        List<WebElement> names = driver.findElements(By.cssSelector("td[field='name']"));
        List<WebElement> users = driver.findElements(By.cssSelector("td[field='assigned_user_name']"));

        for(int i = 0; i < 10; i++) {
            System.out.println(names.get(i).getText() + " - " + users.get(i).getText());
        }
        driver.quit();
    }
}
