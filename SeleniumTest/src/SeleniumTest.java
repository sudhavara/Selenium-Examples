import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rediff.com");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'login1')]")).sendKeys("hjhjk");
        driver.findElement(By.cssSelector("input[name*='passwd']")).sendKeys("password");
        //error on  below line need to fix
        driver.findElement(By.cssSelector("input.signinbtn")).click();






        driver.quit();


    }




//



}



