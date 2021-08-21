package JavaBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    WebDriver driver;

    public static void main(String[] args){

    }

    public WebDriver driverInitiation(){

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        System.out.println("path assigned");
        WebDriver driver = new ChromeDriver();
        System.out.println("driver started");
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver driverclose(WebDriver driver){
        System.out.println("Entered quite method");
        driver.quit();
        System.out.println("exit done");

        return driver;
    }
}
