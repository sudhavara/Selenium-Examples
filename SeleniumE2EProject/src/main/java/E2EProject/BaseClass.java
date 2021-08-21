package E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass implements  AllPagesInterface{

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    public WebDriver driver ;
    public BasePage basepage = new BasePage();
    public LoginPage loginpage = new LoginPage();
    public LandingPage landingpage = new LandingPage();


    @Override
    public WebDriver basePage() {

        basepage.driverInitiation();
        System.out.println("driver initiation done in base class");
        log.info("diver initiion done in base class");
        return driver;
    }

    @Override
    public WebElement landingPage() {
        System.out.println("landed on home page");
        WebElement loginbutton =landingpage.getLoginbutton(driver);
        WebElement aboutbutton=landingpage.getAboutbutton(driver);
        log.info("about button done");
        WebElement compareButton=landingpage.getComparebutton(driver);
        WebElement pricingButton=landingpage.getPricingbutton(driver);
        WebElement iTunesButton= landingpage.getItunesImage(driver);
        WebElement androidButton=landingpage.getAndroidImage(driver);
        WebElement supportButton=landingpage.getSupport(driver);

        return loginbutton;
    }

    @Override
    public WebElement loginPage(WebDriver driver) {


        WebElement Emailid =loginpage.getEmailId(driver);
        loginpage.getEmailId(driver);
        System.out.println("Email id retrieved");
        loginpage.getPassword(driver);
        System.out.println("password id retrieved");
        loginpage.getSubmit(driver);

        return null;
    }




}
