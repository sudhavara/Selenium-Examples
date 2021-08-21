package E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LandingPage {

    public static Logger log = LogManager.getLogger(LandingPage.class.getName());

    WebDriver driver;
    public By login = By.cssSelector("a[href='https://ui.cogmento.com']");
    private By about = By.xpath("//a[@href='about.html']");
    private By compare=By.xpath("//a[@href='compare.html']");
    private By pricing=By.xpath("//a[@href='pricing.html']");
    private By iTunesimage=By.xpath("//img[@alt='iTunes']");
    private By android= By.xpath("//img[@alt='Android']");
    private By support = By.xpath("//a[@href='https://support.cogmento.com/webinars-and-videos']");
    private By navigationbar = By.cssSelector("ul[class='rd-navbar-nav']");




    public WebElement getLoginbutton(WebDriver driver) {
        System.out.println("entered in to getLoginbutton method");
        return  driver.findElement(login);
        }
    public WebElement getAboutbutton(WebDriver driver) {
        System.out.println("entered in to getAboutbutton method");
        return  driver.findElement(about);
    }
    public WebElement getComparebutton(WebDriver driver) {
        System.out.println("entered in to getComparebutton method");
        return  driver.findElement(compare);
    }
    public WebElement getPricingbutton(WebDriver driver) {
        System.out.println("entered in to getPricingbutton method");
        return  driver.findElement(pricing);
    }
    public WebElement getItunesImage(WebDriver driver) {
        System.out.println("entered in to getItunesImage method");
        return  driver.findElement(iTunesimage);
    }
    public WebElement getAndroidImage(WebDriver driver) {
        System.out.println("entered in to getAndroidImage method");
        return  driver.findElement(android);
    }
    public WebElement getSupport(WebDriver driver) {
        System.out.println("entered in to getSupport method");
        return  driver.findElement(support);
    }
    public int getConnectionStatus(WebDriver driver,String strurl) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)new URL(strurl).openConnection();
        connection.connect();
        int iresponsecode = connection.getResponseCode();
        return iresponsecode;
    }
    public WebElement getnavigationBar(WebDriver driver){
        System.out.println("entered in to getnavigationBar method");
        log.info("navigation done");
        return driver.findElement(navigationbar);

    }





}
