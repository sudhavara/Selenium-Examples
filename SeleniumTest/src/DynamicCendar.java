import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicCendar {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.goindigo.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(20000);
        /*
        //Check calendar month
        String calendarmonth = driver.findElement(By.cssSelector("div[class='ui-datepicker-group ui-datepicker-group-last']  [class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']")).getText();
        while(!calendarmonth.contains("July")){
            driver.findElement(By.cssSelector("a[data-handler='next']")).click();

        }*/


        //check calendar date  //a[@class='ui-state-default ui-state-hover']
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-hover']")).click();
        List<WebElement> calendardates =driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
        System.out.println("elements size is "+calendardates.size());
        for(int i =0;i<calendardates.size() ;i++){
            String selecteddate= driver.findElements(By.cssSelector("table[class='ui-datepicker-calendar'] td[data-handler='selectDay']")).get(i).getText();
            System.out.println(selecteddate);
            if(selecteddate.equalsIgnoreCase("29")){
                driver.findElements(By.cssSelector("table[class='ui-datepicker-calendar'] td[data-handler='selectDay']")).get(i).click();
                break;
            }

        }

        driver.quit();

    }
}
