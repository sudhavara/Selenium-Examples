import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class SeleniumTestOld {
    WebDriver driver1;

    {
        driver1 = null;
    }

    public void invokeBrowser() {

        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
            driver1 = new ChromeDriver();

//			driver1.manage().deleteAllCookies();
//			driver1.manage().window().maximize();
//			driver1.manage().window().fullscreen();
//			driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			driver1.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);

            driver1.get("https://www.instacart.com/");
/*
            WebElement formElement = driver.findElement(By.id("skip-to-main-content-link"));
            List<WebElement> allFormChildElements = formElement.findElements(By.xpath("*"));


            WebElement userid = driver1.findElement(By.id("Email address"));
            System.out.println("EmailId found");
            WebElement password = driver1.findElement(By.id("Password"));
            System.out.println("Password found");
            userid.sendKeys("varanasi.sudharani@gmail.com");
            password.sendKeys("Shashank7716");
*/
            //WebElement loginbutton = driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/button"));

            WebElement loginbutton = driver1.findElement(By.xpath("//button[@type='button' and @class='rmq-6ca15ade']"));
            //button[@type='submit' and @class='mat-raised-button mat-primary']
            System.out.println("Login found");
            Thread.sleep(5000); // Let the user actually see something!
            loginbutton.click();
            WebElement username = driver1.findElement(By.id("nextgen-authenticate.all.log_in_email"));
            System.out.println("Email ID found");
            WebElement password = driver1.findElement(By.id("nextgen-authenticate.all.log_in_password"));
            System.out.println("Password found");
            //username.sendKeys("varanasi.sudharani@gmail.com");
            //password.sendKeys("Shashank7716");

            WebElement afterlogin = driver1.findElement(By.xpath("//button[text()='Log in']"));
            System.out.println("after login found");
            afterlogin.click();
            //Thread.sleep(30000);
            /*
            String actualUrl="https://www.instacart.com/store";
            String Expectedurl = driver1.getCurrentUrl();
            Assert.assertEquals( actualUrl,  Expectedurl);
            if(actualUrl.equalsIgnoreCase(Expectedurl)) {

                System.out.println("Test passed");
            } else {
                System.out.println("Test failed") ;
            }*/
            //String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
            //System.out.println("captcha value entered");
            //driver1.findElement(By.xpath("//*[@id=\"skip-to-main-content-link\"]")).sendKeys(captchaVal);
            //driver1.findElement(By.xpath("//*[@id=\"skip-to-main-content-link\"]")).click();

driver1.navigate().to("https://www.instacart.com/store");
            //driver1.get("https://www.instacart.com/store");
            //search the store from given

            String searchclass = "css-cbelw3-HomeSearch";
            List<WebElement> Searchstore = driver1.findElements(By.className("searchclass"));


            Thread.sleep(5000); // Let the user actually see something!

		//driver1.quit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SeleniumTestOld myobject = new SeleniumTestOld();
        myobject.invokeBrowser();

    }
}


