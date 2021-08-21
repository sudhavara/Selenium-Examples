package stepDefinitions;

import E2EProject.BaseClass;
import E2EProject.BasePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class loginSteps extends BaseClass {



    @Given("^Launch the browser$")
    public void launch_the_browser() throws Throwable {
        driver = basepage.driverInitiation();

    }
    @When("^navigate to \"([^\"]*)\"$")
    public void navigateTo(String strURL) throws Throwable {
        System.out.println("strurl is "+strURL);
        driver.get(strURL);
        Thread.sleep(2000);

    }

    @When("^user details entered with (.+) and (.+)$")
    public void user_details_entered_with_something_and_something(String strUserName, String strPassword) throws Throwable {
        landingpage.getLoginbutton(driver).click();
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(30));
        wait.until( ExpectedConditions.visibilityOfElementLocated(loginpage.emailId));
        loginpage.getEmailId(driver).sendKeys(strUserName);
        loginpage.getPassword(driver).sendKeys(strPassword);
        loginpage.getSubmit(driver).click();
        driver.navigate().back();

    }

    @Then("^Successful Login$")
    public void successful_login() throws Throwable
    {


    }



    @And("^click on login to navigate home page$")
    public void click_on_login_to_navigate_home_page() throws Throwable {

    }


    @And("Display element in home page")
    public void displayElementInHomePage() {
    }
}
