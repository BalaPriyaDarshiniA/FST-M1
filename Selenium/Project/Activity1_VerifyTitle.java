package crm;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1_VerifyTitle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm");

        String title = driver.getTitle();
        if(title.equals("SuiteCRM")) {
            System.out.println("Title matched: " + title);
        } else {
            System.out.println("Title NOT matched");
        }
        driver.quit();
    }
}
