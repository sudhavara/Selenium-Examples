import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        action.moveToElement(move).build().perform();
        WebElement serachelement = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        action.moveToElement(serachelement).click().keyDown(Keys.SHIFT).sendKeys("HELLO").build().perform();*/

        //indigo airlines tickets booking using action class choosing from and to
        driver.get("https://www.goindigo.in/");
        driver.manage().window().maximize();
        WebElement fromelement = driver.findElement(By.cssSelector("input[class='form-control or-src-city']"));
        fromelement.clear();

        fromelement.sendKeys("Hyd");
        Thread.sleep(2000);
        WebElement fromplace = driver.findElement(By.xpath("//form[@name ='flight-search']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]"));

        if(fromplace.getText().contains("Hyderabad")){

            fromplace.click();
            Thread.sleep(2000);
        }
        WebElement destination = driver.findElement(By.cssSelector("input[class='form-control or-dest-city'"));
        destination.sendKeys("VISAK");
        Thread.sleep(2000);
        WebElement toelement =  driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[2]/div/div/div/div/div[121]"));

        if(destination.getText().contains("Visakhapatnam")){

            toelement.click();
            Thread.sleep(2000);
        }
        /*Actions actionclass = new Actions(driver);
        actionclass.moveToElement(fromelement).click().sendKeys("Hyd").keyDown(Keys.CLEAR).build().perform();
                Actions actionclass = new Actions(driver);
        actionclass.moveToElement(fromelement).sendKeys("HYD").build().perform();*/


        driver.quit();

    }
}
