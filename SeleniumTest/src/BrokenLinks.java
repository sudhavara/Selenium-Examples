import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BrokenLinks {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         //below code is for broken link on guru99 website
        driver.get("https://www.guru99.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       // List<WebElement> linkelements = driver.findElements(By.xpath("//ul[@class='g-sublevel']/li[2]/a[1]"));
        WebElement weblink = driver.findElement(By.xpath("//span[text()='Web']"));

        //List<WebElement> linkelements = driver.findElements(By.cssSelector("div[class='g-block size-24'] a[class='g-menu-item-container']"));
        List<WebElement> linkelements = driver.findElements(By.xpath("//div[@class='g-block size-24']/ul[@class='g-sublevel']/li/a"));
        System.out.println("linkelements size is"+linkelements.size());
        Actions action = new Actions(driver);
        action.moveToElement(weblink).build().perform();
        //ul[@class='g-sublevel']/li/a
        for(WebElement link:linkelements){
            Thread.sleep(2000);
            action.moveToElement(link).click().build().perform();
            String strcurrenturl = link.getAttribute("href");
            System.out.println(link.getAttribute("href"));
            HttpURLConnection connection = (HttpURLConnection)new URL(strcurrenturl).openConnection();
            connection.connect();
            int responsecode = connection.getResponseCode();
            System.out.println("response code"+responsecode);
            Assert.assertTrue(String.valueOf(responsecode<400),true);


        }
        driver.quit();
        /*
        //WebElement link = driver.findElement(By.xpath("//span[contains(text(),'SAP')]"));
        WebElement move = driver.findElement(By.xpath("//span[contains(text(),'Web')]"));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Web')]")));

        System.out.println("web url value is "+wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Web')]"))).getAttribute("href"));

        WebElement phpmove = driver.findElement(By.xpath("//li[@class='g-menu-item g-menu-item-type-component g-menu-item-128  ']/a[1]//span[contains(text(),PHP)]"));
        String strurl = phpmove.getAttribute("href");
        System.out.println("URL value is"+strurl);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(move).build().perform();

        Thread.sleep(2000);
        action.moveToElement(phpmove).click().build().perform();
        String strcurrenturl = driver.getCurrentUrl();
        System.out.println(" strcurrenturl is "+strcurrenturl);
        HttpURLConnection connection = (HttpURLConnection)new URL(strcurrenturl).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int responsecode = connection.getResponseCode();
        System.out.println("connection response code is "+responsecode);*/


        //Strat new code for the website demo of https://demoqa.com/broken
/*
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        WebElement brokenelement = driver.findElement(By.xpath("//a[contains(text(),'Click Here for Broken Link')]"));

        String strbrokenurl = brokenelement.getAttribute("href");
        System.out.println("brokenurl is "+strbrokenurl);
        HttpURLConnection connection = (HttpURLConnection)new URL(strbrokenurl).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int responsecode = connection.getResponseCode();
        System.out.println("response code is "+responsecode);
        driver.quit();*/

    }
}
