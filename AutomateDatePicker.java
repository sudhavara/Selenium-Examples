package SeleniumInterviewPreparation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateDatePicker {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.phptravels.net");
        String strExpectedmonth = "March 2022";
        String day = "12";
        driver.findElement(By.xpath("//input[@id='checkin']")).click();
        Thread.sleep(2000);
        String strcalendarmonth="";
        while(true) {
            strcalendarmonth = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            if (strcalendarmonth.equalsIgnoreCase(strExpectedmonth)) {

                break;
            }

            driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
        }
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),'13')]")).click();
        driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),"+day+")]")).click();




    }
}