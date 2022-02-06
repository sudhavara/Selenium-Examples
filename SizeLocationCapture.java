package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeLocationCapture {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        //Location

        System.out.println("location details"+logo.getLocation());
        System.out.println("location x coordinate details"+logo.getLocation().getX());
        System.out.println("location y coordinate "+logo.getLocation().getY());

        System.out.println("location size details"+logo.getSize());



    }
}
