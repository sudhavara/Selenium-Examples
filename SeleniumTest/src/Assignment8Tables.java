import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment8Tables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //find table element
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='product']/tbody[1]/tr/th"));
        System.out.println("Total number of columns are "+columns.size());
        //row count
        for(int i =0;i<columns.size();i++){
            String strdata = driver.findElements(By.xpath("//table[@id='product']/tbody[1]/tr/th")).get(i).getText();
            //System.out.println("data is "+strdata);
        }
        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='table-display'] td:nth-child(2)"));
        System.out.println("Total rows are "+rows.size());
       for(int i=0;i<rows.size();i++){
           String strrowdata = driver.findElements(By.cssSelector("table[class='table-display'] td:nth-child(3)")).get(i).getText();
           //System.out.println("row data is "+strrowdata);
       }
       String strcourse = driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr[3]/td[2]")).getText();
       String strprice = driver.findElement(By.cssSelector("table[class='table-display'] tr:nth-child(3) td:nth-child(3)")).getText();
        System.out.println("Price data for course "+strcourse+"is "+strprice);

        System.out.println("Total rows aare "+driver.findElements(By.cssSelector("table[class='table-display'] tr")).size());


        driver.quit();



    }
}
