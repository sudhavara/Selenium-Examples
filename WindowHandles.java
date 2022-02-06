package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String windowId = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
         Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> it = windowIds.iterator();
        String parentId = it.next();
        String childId = it.next();

        List<String> windowidList = new ArrayList(windowIds);
        for(String id:windowidList){
            driver.switchTo().window(id).getTitle();
            //to switch to all window ids and get titles
        }


    }
}
