import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlerts {

    public void invokeBrowser() {

        WebDriver driver;
        //driver1 = null;
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        }


    public static void main(String[] args){

        SeleniumAlerts myobject = new SeleniumAlerts();
        myobject.invokeBrowser();

    }
}
