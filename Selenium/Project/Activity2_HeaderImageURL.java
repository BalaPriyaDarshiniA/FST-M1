package crm;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2_HeaderImageURL {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        String imageURL = driver.findElement(By.cssSelector("img[alt='SuiteCRM']")).getAttribute("src");
        System.out.println("Header Image URL: " + imageURL);

        driver.quit();
    }
}
