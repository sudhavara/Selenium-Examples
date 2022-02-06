package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorlick {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("Ananya1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password456");
        Thread.sleep(2000);
        WebElement button =driver.findElement(By.name("btnLogin"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",button);
        Thread.sleep(2000);

    }
}
