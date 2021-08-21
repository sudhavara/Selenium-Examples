import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class createAccount {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
            Thread.sleep(2000);

            //driver.findElement(By.cssSelector("a.button")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")).click();
            Thread.sleep(2000);
            List<WebElement> accounts = driver.findElements(By.xpath("//li[@role='menuitem']"));
            System.out.println(accounts.get(0).getText());
            accounts.get(0).click();
            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("geetha");
            System.out.println("elem found");
            driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("tarangini");
            System.out.println("password found");

            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("geetha.tarangini");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("password@1980");

            driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("password@1980");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")).click();
            //driver.findElement(By.xpath("//span[@contains(text(),'Next')]")).click();
            //selecting month from calendar
            Thread.sleep(4000);
            WebElement month = driver.findElement(By.cssSelector("select#month"));
            Select select = new Select(month);
            select.selectByValue("12");
            driver.findElement(By.xpath("//input[@name='day']")).sendKeys("21");
            driver.findElement(By.xpath("//input[@name='year']")).sendKeys("1980");
            Select selectGender = new Select(driver.findElement(By.xpath("select#gender")));
            selectGender.selectByValue("2");
            driver.findElement(By.xpath("//span[@contains(text(),'Next')]")).click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            driver.findElement(By.xpath("//span[@contains(text(),'I agree')]")).click();

        }catch (Exception e){
            e.printStackTrace();
            driver.quit();
        }

    }

}
