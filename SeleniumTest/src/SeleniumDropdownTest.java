import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDropdownTest {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag
        //ctl00_mainContent_DropDownListCurrency
                WebElement staticdrop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select selectdrop = new Select(staticdrop);
        selectdrop.selectByIndex(1);
        System.out.println("first selected dropdown is "+ selectdrop.getFirstSelectedOption().getText());
        selectdrop.selectByVisibleText("INR");
        System.out.println("first selected dropdown is "+ selectdrop.getFirstSelectedOption().getText());
        selectdrop.selectByValue("AED");
        System.out.println("first selected dropdown is "+ selectdrop.getFirstSelectedOption().getText());

        driver.quit();




    }
}
