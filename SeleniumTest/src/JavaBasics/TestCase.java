package JavaBasics;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase extends  BaseClass{

    WebDriver driver = null;

    @Test
    public void testCase1() throws InterruptedException {
        driver = basepage.driverInitiation();
        driver.get("https://freecrm.com/");
        landingpage.getLoginbutton(driver).click();
        Thread.sleep(3000);
        loginpage.getEmailId(driver).sendKeys("abc@crm.com");
        loginpage.getPassword(driver).sendKeys("password");
        loginpage.getSubmit(driver).click();
        basepage.driverclose(driver);

    }





}
