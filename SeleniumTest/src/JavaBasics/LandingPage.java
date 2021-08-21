package JavaBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {

    WebDriver driver;
    By login = By.cssSelector("a[href='https://ui.cogmento.com']");



    public WebElement getLoginbutton(WebDriver driver) {
        System.out.println("entered in to getLoginbutton method");

        return  driver.findElement(login);


    }





}

