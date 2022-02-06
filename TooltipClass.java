package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipClass {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement input = driver.findElement(By.xpath("//input[@id='age']"));
        String strtooltipmessage = input.getAttribute("title");
        System.out.println("strtooltipmessage is "+strtooltipmessage);



    }
}
