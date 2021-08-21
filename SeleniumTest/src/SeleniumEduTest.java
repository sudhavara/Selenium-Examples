import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEduTest {

    public void invokeBrowser() {

        WebDriver driver;
        //driver1 = null;
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        //finding by css selector
       // driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Camera");
        //finding by xpath
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Camera");


        System.out.println("search box found");
       // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Camera");

       // driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        System.out.println("search button found");



/*
        string checkboxXPath = "//input[contains(@id, 'lstCategory_0')]";
        IWebElement elementToClick = driver.FindElement(By.XPath(checkboxXPath));
        elementToClick.Click();*/


        driver.findElement(By.linkText("Fujifilm")).click();

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.navigate().to("https://instacart.com");


        driver.navigate().back();
        driver.quit();
    }


    public static void main(String[] args){

        SeleniumEduTest myobject = new SeleniumEduTest();
        myobject.invokeBrowser();

    }
}
