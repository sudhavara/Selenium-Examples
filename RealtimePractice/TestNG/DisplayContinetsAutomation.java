package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DisplayContinetsAutomation {

    WebDriver driver;


    @BeforeTest
    public void driverInitiation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void diaplayNames() throws InterruptedException {

        driver.get("https://www.worldometers.info/geography/7-continents/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

        List<WebElement> continentNames = driver.findElements(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr/td[2]/a"));
        for(WebElement name :continentNames){
            System.out.println(name.getText());
            Thread.sleep(2000);
        }

        driver.quit();


    }





}
