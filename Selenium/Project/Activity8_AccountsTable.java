package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class Activity8_AccountsTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Accounts")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("table.list.view tbody tr"));

        for(int i = 0; i < 5; i += 2) {
            System.out.println(rows.get(i).getText());
        }
        driver.quit();
    }
}
