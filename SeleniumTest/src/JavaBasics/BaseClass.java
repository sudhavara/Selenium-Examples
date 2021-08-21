package JavaBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class BaseClass implements BasicInterface {
WebDriver driver = null;
    BasePage basepage = new BasePage();
    LoginPage loginpage = new LoginPage();
    LandingPage landingpage = new LandingPage();


    @Override
    public WebDriver basePage() {

        basepage.driverInitiation();
        System.out.println("driver initiation done in base class");
        return driver;
    }

    @Override
    public WebElement landingPage() {
        System.out.println("landed on home page");
       WebElement loginbutton =landingpage.getLoginbutton(driver);
        return loginbutton;
    }

    @Override
    public WebElement loginPage() {


        WebElement Emailid =loginpage.getEmailId(driver);
        loginpage.getEmailId(driver);
        System.out.println("Email id retrieved");
        loginpage.getPassword(driver);
        System.out.println("password id retrieved");
        loginpage.getSubmit(driver);

        return null;
    }




}
