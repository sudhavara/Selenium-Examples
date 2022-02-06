package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.findElement(By.cssSelector("input#input-username")).clear();
        driver.findElement(By.cssSelector("input#input-username")).sendKeys("demo");
        driver.findElement(By.cssSelector("input#input-password")).clear();
        driver.findElement(By.cssSelector("input#input-password")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        driver.findElement(By.xpath("//li[@id='menu-sale']")).click();
        driver.findElement(By.xpath("//li[@id='menu-sale']//a//i")).click();
        driver.findElement(By.linkText("Sales")).click();
        System.out.println("sale link text found");

        Thread.sleep(2000);
        //orders

        driver.findElement(By.linkText("Orders")).click();
        Thread.sleep(2000);

        //find total number of pages

        String strpagesText = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 20 of 11132 (557 Pages)')]")).getText();
        System.out.println("strpagesText index is "+strpagesText.indexOf("("));
        String subStringdata = strpagesText.substring(strpagesText.indexOf("(")+1,strpagesText.indexOf("P")-1);
        System.out.println("substring data is "+subStringdata);
        int totalpages = Integer.valueOf(subStringdata);
        System.out.println("total pages are "+totalpages);

        for(int i =0;i<10;i++){
            String strcurrentpage=driver.findElement(By.xpath("//ul[@class='pagination']//li/span")).getText();
            System.out.println("strcurrentpage is "+strcurrentpage);
            driver.findElement(By.xpath("//ul[@class='pagination']//li/span")).click();
            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("rows total ois "+rows);
            int j =0;
            j=j+1;
            String strpagenumber = Integer.toString(j+1);
            System.out.println("pagenum is cative "+strpagenumber);
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+strpagenumber+"']")).click();

        }

        driver.quit();






    }
}
