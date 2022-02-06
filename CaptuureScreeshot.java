package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptuureScreeshot {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;driver.get("https://demo.nopcommerce.com");
        //full page screensphot
        //********************************************************
        /*
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File tgt =new File("D:\\HomeWork\\samplscreenshot.png");
        FileUtils.copyFile(src,tgt);*/

        // ************* capture portion of webelement
        WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File tgt =new File("D:\\HomeWork\\samplscreenshot.png");
        FileUtils.copyFile(src,tgt);


        driver.close();



    }
}
