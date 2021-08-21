
package E2EProject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    public static Logger log = LogManager.getLogger(LoginPageTest.class.getName());
    WebDriver driver = null;

    @BeforeTest
    public void diverInitiationTest(){
        driver = basepage.driverInitiation();
        log.info("driverinitiation done");
    }


    @Test(dataProvider = "getData")
    public void loginAction(String strusername,String strpassword) throws InterruptedException {
        driver.get("https://freecrm.com/");
        landingpage.getLoginbutton(driver).click();
        Thread.sleep(2000);
        loginpage.getEmailId(driver).sendKeys(strusername);
        loginpage.getPassword(driver).sendKeys(strpassword);
        loginpage.getSubmit(driver).click();
        log.debug("got the data");

    }



    @DataProvider
    public Object[][] getData(){
        //for two entries three columns data means attributes data
        Object[][] data = new Object[2][2];
        data[0][0]="nonrestricteduser@gmail.com";
        data[0][1]="password1";
        // data[0][2]="nonrestricted user";
        data[1][0]="restricteduser@gmail.com";
        data[1][1]="password2";
        //data[0][2]="restricted user";
        return data;
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        driver.get("https://freecrm.com/");
        landingpage.getLoginbutton(driver).click();
        Thread.sleep(4000);
        loginpage.getForgotPassword(driver).click();
        loginpage.getEmailId(driver);
        loginpage.getResetButton(driver).click();

    }

    @Test
    public void classicCRM() throws InterruptedException {
        driver.get("https://freecrm.com/");
        landingpage.getLoginbutton(driver).click();
        Thread.sleep(2000);
        loginpage.getClassicCRM(driver).click();




    }

    @AfterTest
    public void tearDown(){
       driver.quit();

    }



}
