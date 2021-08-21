package JavaBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
        WebDriver driver = null;

    By emailId = By.cssSelector("input[name='email']");
    By password = By.cssSelector("input[name='password']");
    By submit = By.cssSelector("div[class='ui fluid large blue submit button']");



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


}
