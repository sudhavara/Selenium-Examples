import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Assginment1 {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver .get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//legend[text()='Checkbox Example']")).click();
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        boolean bcheck = driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
        System.out.println("checkbox 1 is selected "+bcheck);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(bcheck == true){
            System.out.println("deselecting the checkbox");
            driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


       //get the checkboxes count

  List<WebElement> options = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Checkboxes count is "+options.size());


driver.quit();



    }
}
