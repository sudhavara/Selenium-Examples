package E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //WebDriver driver = null;

    public By emailId = By.cssSelector("input[name='email']");
    private By password = By.cssSelector("input[name='password']");
    private By submit = By.cssSelector("div[class='ui fluid large blue submit button']");
    private By forgotPassword = By.cssSelector("a[href='https://register.cogmento.com/password/reset/request/']");
    private By classicCRM = By.cssSelector("a[href='https://classic.freecrm.com/login.cfm']");
    private By signup=By.cssSelector("a[href='https://api.cogmento.com/register']");
    private By resetbutton = By.cssSelector("button[name='action']");



    public WebElement getEmailId (WebDriver driver) {
        System.out.println("entered in to getemail method");
        return  driver.findElement(emailId);


    }

    public WebElement getPassword (WebDriver driver) {
        System.out.println("entered in to getpassword method");

        return driver.findElement(password);
    }

    public WebElement getSubmit(WebDriver driver) {
        System.out.println("entered in to getSubmit method");

        return driver.findElement(submit);
    }
    public WebElement getForgotPassword(WebDriver driver) {
        System.out.println("entered in to getForgotPassword method");

        return driver.findElement(forgotPassword);
    }
    public WebElement getClassicCRM(WebDriver driver) {
        System.out.println("entered in to getClassicCRM method");

        return driver.findElement(classicCRM);
    }
    public WebElement getSignUP(WebDriver driver) {
        System.out.println("entered in to getSignUP method");

        return driver.findElement(signup);
    }
    public WebElement getResetButton (WebDriver driver) {
        System.out.println("entered in to getResetButton method");
        return  driver.findElement(resetbutton);


    }



}
