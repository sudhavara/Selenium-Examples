package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CanvasDrawingAutomation {

    @Test
    public void signatureVerification() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.signwell.com/online-signature/draw/");
        driver.manage().window().maximize();
        WebElement canvas = driver.findElement(By.xpath("//canvas[@id='canvas_signature']"));
        Actions builder = new Actions(driver);
        int sourceX =100;
        int sourceY =50;
        int tagetX=200;
        int targetY=100;
        /*
        builder.moveToElement(canvas).perform();
        builder.clickAndHold(canvas).perform();
        builder.moveByOffset(150, 50).perform();
        builder.moveToElement(canvas).perform();
        builder.clickAndHold(canvas).perform();
        builder.moveByOffset(100, 50).perform();
        builder.moveToElement(canvas).perform();
        Thread.sleep(2000);*/

        builder.moveToElement(canvas).build().perform();
        builder.clickAndHold(canvas).build().perform();
        builder.moveToElement(canvas,150, 50).click().perform();

        builder.moveToElement(canvas).build().perform();
        builder.clickAndHold(canvas).perform();
        builder.moveToElement(canvas,100, 50).click().perform();
        builder.moveToElement(canvas).perform();
        builder.clickAndHold(canvas).perform();
        builder.moveToElement(canvas,300, 10).click().perform();
        Thread.sleep (5000);


        driver.quit();


    }
}
