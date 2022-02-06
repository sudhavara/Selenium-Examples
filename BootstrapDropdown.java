package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdown {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hdfcbank.com");
        driver.findElement(By.xpath("//div[@class='dropdown open']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//div[@class='dropdown open']//ul[@class='dropdown1 dropdown-menu']/li"));
        System.out.println("number of options "+productTypes.size());
        for(WebElement product:productTypes){
            if(product.getText().equals("Accounts")){
                product.click();
                break;
            }
        }
    }
}

//can write generi method if more select dropdowns there.
