package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePickerAutomation {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Datepicker.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
        Thread.sleep(2000);
        //To check th emonth April
        WebElement next = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']"));
        while(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']")).isEnabled()) {
            next = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']"));
            WebElement dateTitle = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
            System.out.println("date Title text is " + dateTitle.getText());
            String strdateTitle = dateTitle.getText();
            String strdate[] = null;
            strdate = strdateTitle.split(" ");
            String strmonth = strdate[0];
            System.out.println("strmonth is " + strmonth);
            String strYear = strdate[1];

            System.out.println("strYear is " + strYear);

            if (strmonth.equalsIgnoreCase("April")) {
                System.out.println("january matched and break");
                //table[@class='ui-datepicker-calendar']/tbody/tr/td
                break;

            }else{
                System.out.println("Went in to ele block for next month");
                next = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']"));
                next.click();
                System.out.println("next clicked");

                Thread.sleep(2000);
            }
        }
            List<WebElement> datesList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
            for (WebElement date : datesList) {

                if (date.getText().equals("20")) {
                    date.click();
                    System.out.println("date clicked ");
                    Thread.sleep(2000);
                    break;

                }


            }


        driver.quit();


    }
}
