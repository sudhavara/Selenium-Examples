import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Assignment5 {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("frames coint"+driver.findElements(By.tagName("frame")).size());
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@name='frame-top']")));

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        System.out.println("outer frame size is "+driver.findElements(By.tagName("frame")).size());

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
