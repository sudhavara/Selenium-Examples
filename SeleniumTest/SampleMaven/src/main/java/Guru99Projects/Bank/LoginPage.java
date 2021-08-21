package Guru99Projects.Bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    WebDriver driver;
    private By userId = By.xpath("//input[@name='uid']");
    private By password =  By.xpath("//input[@name='password']");
    private By logIn = By.xpath("//input[@name='btnLogin']");
    private By reset = By.xpath("//input[@name='btnReset']");
    private By userIdLabel = By.xpath("//label[@id='message23'");
    private By passwordLabel = By.xpath("//label[@id='message18']");
    private By managerIdmesssge=By.xpath("//td[@style='color: green']");
    private By welcomeMessage = By.xpath("//marquee[@class='heading3']");



    public WebElement getUserId(WebDriver driver){
        System.out.println("entered in to getUserId method");
        return driver.findElement(userId);

    }
    public WebElement getpassword(WebDriver driver){
        System.out.println("entered in to getpassword method");
        return driver.findElement(password);

    }
    public WebElement getlogIn(WebDriver driver){
        System.out.println("entered in to getlogIn method");
        return driver.findElement(logIn);

    }
    public WebElement getreset(WebDriver driver){
        return driver.findElement(reset);

    }
    public WebElement getuserIdLabel(WebDriver driver){
        return driver.findElement(userIdLabel);

    }
    public WebElement getpasswordLabel(WebDriver driver){
        return driver.findElement(passwordLabel);

    }
    public String getSno(WebDriver driver){
        String strnumber = "1";
        return strnumber;
    }

    public WebElement getmanagerIdmessage(WebDriver driver){
        return driver.findElement(managerIdmesssge);

    }
    public WebElement getwelcomeMessage(WebDriver driver){
        return driver.findElement(welcomeMessage);

    }


}
