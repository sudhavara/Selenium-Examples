import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w =new WebDriverWait(driver,5);
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        System.out.println("page loaded");

        driver.findElement(By.xpath("//body/div[@id='content']/a[2]")).click();
        System.out.println("Element found");

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
        String message = driver.findElement(By.xpath("//div[@id='results']")).getText();
        System.out.println("text message is "+message);
        driver.quit();
    }
}
