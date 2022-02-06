package SeleniumInterviewPreparation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteGooglePlacesDropdown {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.twoplugs.com/");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement Searchbox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        Searchbox.sendKeys("Toronto");
        String text = null;
        do{

            Searchbox.sendKeys(Keys.ARROW_DOWN);
            text = Searchbox.getAttribute("value");
            if(text.equals("Toronto, OH, USA")){
                Searchbox.sendKeys(Keys.ENTER);
                break;
            }

        }while(!text.isEmpty());



    }
}
