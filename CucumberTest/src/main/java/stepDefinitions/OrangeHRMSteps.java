package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRMSteps {
    WebDriver driver ;

    @Given("I Launch Chrome Browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
         driver = new ChromeDriver();


    }
    @When("I open Orange HRM homepage")
    public void i_open_orange_hrm_homepage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }
    @Then("I Verify Logo Presence")
    public void i_verify_logo_presence() {
        boolean status = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
        Assert.assertTrue(status);

    }
        @Then("^Enter user details with \"([^\"]*)\" and \"([^\"]*)\"$")
        public void enter_user_details_with_something_and_something(String struserName, String strpassword) throws Throwable {
            System.out.println("user name is "+struserName);
            System.out.println("user name is "+strpassword);
            driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(struserName);
            driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(strpassword);
            driver.findElement(By.cssSelector("input#btnLogin")).submit();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);


        }


    @And("Close Browser")
    public void close_browser() {
        driver.quit();

    }

}
