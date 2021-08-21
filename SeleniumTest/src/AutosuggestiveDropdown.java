import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutosuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("IND");
Thread.sleep(3000);
        List<WebElement> itemslist = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement item :itemslist){

            if(item.getText().equalsIgnoreCase("India")){
                item.click();
                break;

            }

        }

driver.quit();
    }
}
