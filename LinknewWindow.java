package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class LinknewWindow {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.monsterindia.com/");
         WebElement login = driver.findElement(By.xpath("//header/div[1]/div[3]/div[1]/div[1]/nav[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]/span[2]"));
         Thread.sleep(2000);
/*
        Actions action = new Actions(driver);
         action.contextClick(login).build().perform();*/
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);

        login.sendKeys(clicklnk);



    }
}
