import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("UNITED");
        //driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/div[1]")).click();
        Thread.sleep(5000);
        List<WebElement> countrylist = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div[1]"));
        System.out.println("country list is "+countrylist.size());
        /*
        for(int i=0;i<countrylist.size();i++){
            System.out.println("Entered in to for loop");

            System.out.println("text message is"+countrylist.get(i).getText());
            WebElement element = countrylist.get(i);
            String strcountryname =countrylist.get(i).getText();
            if(strcountryname.contains("United States (USA)")){
                countrylist.get(i).click();
                Thread.sleep(2000);
            }

        }*/
        driver.findElement(By.id("autocomplete")).sendKeys("Uni");

        Thread.sleep(2000);


        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);





        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

        driver.quit();
       // li.ui-menu-item
    }
}
