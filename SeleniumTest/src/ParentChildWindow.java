import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ParentChildWindow {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        System.out.println("parent id "+parentId);
        String Childid = it.next();
        System.out.println("Childid id "+Childid);
        driver.switchTo().window(Childid);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());

        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(emailId);
        */
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();


        driver.findElement(By.cssSelector(".blinkingText")).click();
        String parentid=driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator<String> it = windows.iterator();
        while(it.hasNext()){
            String childId = it.next();
            if(!parentid.equals(childId)) {
                driver.switchTo().window(childId);
                System.out.println(driver.switchTo().window(childId).getTitle());
            }

        }



            //String parentId = it.next();








        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentid);

        driver.findElement(By.id("username")).sendKeys(emailId);
        driver.quit();






















    }
}
