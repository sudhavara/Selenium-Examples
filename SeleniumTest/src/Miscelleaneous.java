import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleaneous {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //interview question
        driver.manage().deleteCookieNamed("Session-key");
        //click on any link
        //login page will be redirected and verification continues
        //to screen shot

        driver.get("http://qaclickacademy.com/practice.php");
       File srreenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srreenshotfile,new File("D:/TestFilesScreenshot.png"));


    }
}
