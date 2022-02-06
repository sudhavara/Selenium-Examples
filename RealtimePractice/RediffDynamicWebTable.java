package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RediffDynamicWebTable {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://money.rediff.com/losers/bse/daily");
        driver.manage().window().maximize();
        //go to gainers mnothly section
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='leftcontainer']/div[2]/h2[1]")).click();
        Thread.sleep(2000);

        List<WebElement> schedules = driver.findElements(By.xpath("//body[1]/div[2]/div[5]/div[2]/div/a"));

        for(WebElement schedule:schedules) {
            if (schedule.getText().equalsIgnoreCase("Monthly")) {
                schedule.click();

                Thread.sleep(2000);
                List<WebElement> groups = driver.findElements(By.xpath("//body/div[@id='wrapper']/div[@id='leftcontainer']/div/a"));
                for(int i=0;i<groups.size();i++) {
                    if(groups.get(i).getText().equalsIgnoreCase("Group M")){
                        System.out.println("Entered in to groupMT block");
                        try {
                            driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='leftcontainer']/div/a[" + (i + 1) + "]")).click();
                            Thread.sleep(2000);
                            System.out.println("out of for loop ");
                            System.out.println("Prev close name is "+driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[3]")).getText());
                            List<WebElement> prevcloseelements = driver.findElements(By.xpath("//table[@class='dataTable']/tbody[1]/tr/td[3]"));
                            System.out.println("size is "+prevcloseelements.size());
                            //table[@class='dataTable']/tbody/tr/td[3]


                        }catch (StaleElementReferenceException ste){
                            driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='leftcontainer']/div/a[" + (i + 1) + "]")).click();
                            Thread.sleep(2000);
                        }
                        break;

                    }
                }


            }
            Thread.sleep(2000);
            //below code not working check
            System.out.println("percent change name is "+driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[5]")).getText());
            List<WebElement> percentageelemnts = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[5]"));
            System.out.println("prev close total row count is "+percentageelemnts.size());




        }
        driver.quit();
        //clicking on group MT

    }
}
