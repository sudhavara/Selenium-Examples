package E2EProject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTest extends BaseClass{

     static Logger logger = LogManager.getLogger(HomePageTest.class.getName());
    WebDriver driver = null;
    String strlinkURL;

    @BeforeTest
    public void diverInitiationTest(){
        driver = basepage.driverInitiation();
        logger.info("driverinitiation done");
    }

    @Test

    public void validLinks() throws IOException, InterruptedException {
        String strweburl = basepage.getProperty("URL");
        driver.get(basepage.getProperty("URL").toString().trim());
        Thread.sleep(3000);
        System.out.println("title is"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"#1 Free CRM customer relationship management software cloud");
        landingpage.getAboutbutton(driver).click();
        strlinkURL =driver.getCurrentUrl();
        int responseCode = landingpage.getConnectionStatus(driver,strlinkURL);
        Assert.assertTrue(true,String.valueOf(responseCode<400));
        Assert.assertEquals(strlinkURL,"https://freecrm.com/about.html");
        driver.navigate().back();
        Assert.assertTrue(true,String.valueOf(landingpage.getnavigationBar(driver).isDisplayed()));
        logger.debug("Testcases passed");
    }

    @AfterTest
    public void tearDown(){
       driver.quit();

    }


}
