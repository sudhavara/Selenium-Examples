import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        WebElement frameelement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameelement);
        WebElement sourceelement = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetelement = driver.findElement(By.cssSelector("div#droppable"));
        Actions mouseaction = new Actions(driver);
        mouseaction.dragAndDrop(sourceelement,targetelement).build().perform();
        driver.switchTo().defaultContent();
        driver.quit();

    }
}
