package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SignatureAutomation {

    @Test
    public void signatureVerification() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.signwell.com/online-signature/draw/");
        driver.manage().window().maximize();
        WebElement canvas = driver.findElement(By.xpath("//canvas[@id='canvas_signature']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(canvas,200,0).build().perform();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement button = driver.findElement(By.xpath("//button[@id='signature-save']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
}
