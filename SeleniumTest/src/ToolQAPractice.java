import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ToolQAPractice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Textbox check
        driver.get("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input#userName")).sendKeys("trainer");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#userEmail")).sendKeys("trainer@email.com");
        driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("address1");

        driver.findElement(By.cssSelector("textarea#permanentAddress")).sendKeys("address1");
        driver.findElement(By.cssSelector("button#submit")).submit();
        driver.quit();
    }
}
