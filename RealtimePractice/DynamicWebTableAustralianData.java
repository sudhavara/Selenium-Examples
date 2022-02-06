package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebTableAustralianData {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www2.asx.com.au/");
        driver.manage().window().maximize();
        System.out.println("maximized");
        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement button = driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"))));
        button.click();
        driver.findElement(By.xpath("//div[@id='pnProductNavContents']/li[3]")).click();
        System.out.println("Price sensitive Announcem,ents clicked");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement moreannounce = driver.findElement(By.xpath("//span[contains(text(),'SEE All Announcements')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",moreannounce);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'SEE All Announcements')]"))));
        moreannounce.click();

        System.out.println("Next announce,entes clicked");
        Thread.sleep(2000);


        //
        Thread.sleep(2000);
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='external-form__iframe default']"));
        driver.switchTo().frame(frame);
        System.out.println("frame switched");
        Thread.sleep(2000);

        driver.findElement(By.tagName("table")).click();
        System.out.println("table found");
        //div[@class='t402-prompt-websat-shadow js-content-for-height']/div/div/div[@title='Close survey']
        //driver.quit();

    }
}
