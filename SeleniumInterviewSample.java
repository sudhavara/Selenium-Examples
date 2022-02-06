package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumInterviewSample {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        WebElement serachbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("serach box xcheck"+serachbox.isDisplayed());
        System.out.println("seach box enabled"+serachbox.isEnabled());

        WebElement link = driver.findElement(By.xpath("//div[@class='footer']//a"));
        System.out.println("first link text is "+ link.getText());
        List<WebElement> links =   driver.findElements(By.xpath("//div[@class='footer']//a"));
        for(WebElement ele:links){
            System.out.println("link text is "+ele.getText());
        }



    }
}
