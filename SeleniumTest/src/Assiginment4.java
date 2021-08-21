import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assiginment4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//div[@class='example']/a[1]")).click();


        Set<String> windows = driver.getWindowHandles();
        System.out.println("windows size is "+windows.size());
        Iterator<String> it = windows.iterator();

        String parentid = it.next();
        String childid = it.next();
        String child2id = it.next();
        driver.switchTo().window(child2id);
        System.out.println("child2 title is "+driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

        driver.switchTo().window(childid);
        System.out.println("child title is "+driver.getTitle());


         System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

         driver.switchTo().window(parentid);

         //System.out.println(driver.findElement(By.xpath("")));



        Thread.sleep(2000);


        driver.quit();
    }
}
