package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*
        driver.get("http://the-internet.herokuapp.com/key_presses");
        Actions action = new Actions(driver);
        //driver.findElement(By.xpath("//input[@id='target']")).click();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);*/
        // for cltiple keyboard actions like CTRL+C and paste


        driver.get("https://text-compare.com/");
        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        input1.sendKeys("Welcome to this Page");
        Thread.sleep(2000);
        Actions action = new Actions(driver);

        //to select the text

        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.perform();
        //to copy the text
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.perform();

        //shift to secomd box

        action.sendKeys(Keys.TAB).perform();
        //to paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.perform();


        //to paste in to other box



    }
}
