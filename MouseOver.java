package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com");
        driver.manage().window().maximize();
        WebElement structure = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[@class='dropdown']//a[text()='Desktops']"));
        System.out.println("Element found");
        Thread.sleep(2000);


        Actions act = new Actions(driver);
        act.moveToElement(structure).build().perform();

    }
}
