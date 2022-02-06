package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaginationWebTableOpenCart {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input#input-username")).clear();
        driver.findElement(By.cssSelector("input#input-username")).sendKeys("demo");
        driver.findElement(By.cssSelector("input#input-password")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).submit();
        driver.findElement(By.xpath("//li[@id='menu-sale']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[1]/a")).click();
        Thread.sleep(2000);
        WebElement next = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='>']"));

        //Started new logic

        while(next.isEnabled()) {
            System.out.println("next page is enabled");

            WebElement lastPage = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='>|']"));
            lastPage.click();

            String strlastPageNum = driver.findElement(By.xpath("//ul[@class='pagination']/li/span")).getText();

            int ilastPageNum = Integer.parseInt(strlastPageNum);
            System.out.println("last page number is "+ilastPageNum);

            Thread.sleep(2000);
            driver.navigate().back();
            System.out.println("navigated back to first page");
            int iIndexNum = 0;
            int ieachPagerows =0;
            int itotalpageRows = 0;
            for(int i=0;i<ilastPageNum;i++){
                WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
                WebDriverWait wait = new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='pagination']/li/span")));

                activePage.click();
                System.out.println("Active page clicked for pagenumber "+i);
                Thread.sleep(2000);

                next = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='>']"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='pagination']/li/a[text()='>']")));
                next.click();
                System.out.println("Next button clicked for pagenumber "+i);
                Thread.sleep(2000);
                //Get the all rows count fo reach page
                List<WebElement> rows =driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[1]"));
                System.out.println("Total rows in each page is "+ rows.size());
                ieachPagerows = rows.size();
                itotalpageRows = itotalpageRows+ieachPagerows;
                iIndexNum++;
            }
            System.out.println("Final index number is "+iIndexNum);
            System.out.println("itotalpageRows is "+itotalpageRows);
            if(iIndexNum == ilastPageNum){
                break;

            }


        }
        driver.quit();


       }
}







