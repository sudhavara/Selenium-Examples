package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadfileRobotclass {

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.monsterindia.com/");
        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
        WebElement fileupload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Robot robo = new Robot();
        robo.delay(1000);
        StringSelection ss = new StringSelection("D:\\SeleniumUdemy\\DatadriveTesting\\employeeData.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyPress(KeyEvent.VK_ENTER);

    }
}
