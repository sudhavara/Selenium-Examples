package SeleniumInterviewPreparation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EnterTextCAPS {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/how-to-enter-a-letter-in-uppercase-in-the-edit-box-using-actions-in-selenium");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//input[@name='key']"));
        Actions act = new Actions(driver);
        act.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Welcome tag").build().perform();
        Thread.sleep(3000);
        driver.quit();


    }
}
