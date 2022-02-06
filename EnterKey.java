package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EnterKey {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/community/127/specify-enter-button-functionality-selenium-webdriver-code");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//form[@class='search-form']/div/input[1]"));

        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("appium course").build().perform();
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();


    }
}
