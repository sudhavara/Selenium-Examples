import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxTest {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        System.out.println("check box selected"+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println("check box selected"+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //number of checkboxes

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("checkbox count is "+checkboxes.size());

        driver.quit();


    }
}
