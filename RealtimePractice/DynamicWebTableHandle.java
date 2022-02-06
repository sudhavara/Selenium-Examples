package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicWebTableHandle {

    public static void main(String[] args)
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='dataTable']/thead[1]/tr/th"));

        for(WebElement ele:columns){
            System.out.println("Column name "+ele.getText());

            System.out.println();
        }
        int irowCount =0;
        List<WebElement> Rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

          System.out.println("Row count is "+Rows.size());
        System.out.println("Current Price total rows are "+driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]")).size());

        System.out.println("Prev Close total rows are "+driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]")).size());
        List<WebElement> currentpriceele = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
        double totalpriceel=0.0;
        String priceel="";
        for(WebElement priceele:currentpriceele){
             priceel = priceele.getText();

           // System.out.println("Double values is "+ Double.parseDouble(priceel));
            totalpriceel = totalpriceel+Double.parseDouble(priceel);



        }
        System.out.println("Total current orice is "+totalpriceel);

        List<WebElement> companyNames  = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr/td/a"));
        for(int i=0;i<companyNames.size();i++){
            System.out.print(companyNames.get(i).getText());
            System.out.print("   |    ");
            System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']//tbody/tr["+(i+1)+"]/td[3]")).getText());
            System.out.print("   |    ");
            System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']//tbody/tr["+(i+1)+"]/td[4]")).getText());
            System.out.println();
        }



        driver.quit();








    }
}
