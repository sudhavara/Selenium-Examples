package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EMICalculatorAutomation {


    WebDriver driver;
    @BeforeTest

    public void driverIniitaition(){

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

    }


    @Test
        public void loanAmountCaluculator() throws InterruptedException {

        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        //drag home loan amount
        Actions actions = new Actions(driver);
        WebElement dragLoan = driver.findElement(By.xpath("//div[@id='loanamountslider']/span"));
        System.out.println("WebElemnt found");
        actions.dragAndDropBy(dragLoan, 82, 0).build().perform();
        Thread.sleep(2000);
        //Drag interest rate
        WebElement dragIntrestRate = driver.findElement(By.xpath("//div[@id='loaninterestslider']/span"));
        actions.dragAndDropBy(dragIntrestRate, 216, 0).build().perform();
        Thread.sleep(2000);
        WebElement loanterm = driver.findElement(By.xpath("//input[@id='loanterm']"));
        loanterm.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        loanterm.sendKeys(Keys.chord("15"), Keys.ENTER);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");
        WebElement loanEMI = driver.findElement(By.xpath("//div[@id='emiamount']/p/span"));
        String strloanAmount = loanEMI.getText();
        System.out.println("strloanAmount is " + strloanAmount);

        Assert.assertEquals("92,439",strloanAmount);

    }


    @AfterTest

    public void closeDriver(){
        driver.quit();
    }








}
