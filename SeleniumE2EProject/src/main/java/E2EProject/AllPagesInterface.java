package E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public interface AllPagesInterface {

     public static Logger log = LogManager.getLogger(AllPagesInterface.class.getName());


     WebDriver driver = null;

     public WebDriver basePage();
     public WebElement landingPage();
     public WebElement loginPage(WebDriver driver);



}
