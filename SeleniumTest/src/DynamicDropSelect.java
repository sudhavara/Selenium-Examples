import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicDropSelect {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='HYD']")).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VTZ']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();




        /*
        driver.findElement(By.xpath("//body/div[@id='body']/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]")).click();
        System.out.println("from value found");
        driver.findElement(By.cssSelector("div[data-name='Hyderabad'][1]")).click();

        driver.findElement(By.cssSelector("input[name='or-src']")).click();
        driver.findElement(By.xpath("//input[@name='or-src']")).sendKeys("Mum");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@name='or-src']")).sendKeys(Keys.DOWN);
        WebElement selectkey =  driver.findElement(By.xpath("//input[@name='or-src']"));
        System.out.println(" value is "+ driver.findElement(By.xpath("//input[@name='or-src']")).getAttribute("value"));
       // Keys fromkeys = new Keys(selectkey);






        driver.findElement(By.xpath("//input[@name='or-dest']")).click();
        driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys("Del");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys(Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//input[@name='or-dest']")).getAttribute("value"));





        //System.out.println("departure element found");
        //driver.findElement(By.xpath("//div[@data-name='Hyderabad']")).click();
        /*

        //driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VTZ']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']")).click();

        //driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VTZ']")).click();
        System.out.println("visakahapatnam element found");*/

        driver.quit();


    }
}
