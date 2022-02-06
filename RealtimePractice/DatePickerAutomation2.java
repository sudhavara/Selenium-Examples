package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePickerAutomation2 {

    public static  void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Datepicker.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
        System.out.println("date picker  calendar clicked");
        List<WebElement> monthoptions = driver.findElements(By.xpath("//div[@class='datepick-month-header']/select[1]/option"));
        for(WebElement month:monthoptions){
            if(month.getText().equals("June")){
                month.click();
                System.out.println("Month clicked ");
                Thread.sleep(2000);
                break;
            }
        }

        List<WebElement> yearoptions = driver.findElements(By.xpath("//div[@class='datepick-month-header']/select[2]/option"));
        for(WebElement year:yearoptions){
            if(year.getText().equals("2023")){
                year.click();
                System.out.println("year clicked ");
                Thread.sleep(2000);
                break;
            }
        }

        //Pick the dates

        List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepick-month']/table/tbody/tr/td"));
        for(WebElement date:dates){
            String strdate = date.getText();
            if(strdate.equals("27")){
                date.click();
                System.out.println("date clicked");
                Thread.sleep(2000);
                break;
            }
        }

        driver.quit();





    }

}
