import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class AmazonTest {



/*
    @BeforeClass
    public static void setlogger(){
        System.setProperty("log4j.configurationFile","log4j2-test.xml");
         logger = LogManager.getLogger(AmazonTest.class);
    }*/



    private static Logger logger = LogManager.getLogger(AmazonTest.class.getName());
        @Test
        public static void TestCase1() {

            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            System.out.println("maximized window");
            logger.info("Window maximized to initiate driver");

            driver.get("https://www.amazon.com/");
            logger.info("Amazon webpage opened");
            Actions actions = new Actions(driver);
            WebElement search = driver.findElement(By.cssSelector("inpu#twotabsearchtextbox"));
            actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("capitalletters").doubleClick().build().perform();
            logger.info("Search box enabled");
            actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
            logger.debug("accountlinst mouse over done");
            actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
            logger.info("context click done");
            driver.quit();

        }
    }




