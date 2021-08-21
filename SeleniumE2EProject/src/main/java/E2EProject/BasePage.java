package E2EProject;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class BasePage {

     WebDriver driver;
    public static Logger log = LogManager.getLogger(BasePage.class.getName());


    public static void main(String[] args){

    }

    public WebDriver driverInitiation(){
        /* this is for maven and jenkins command using parameters from jenkins
        System.out.println("WebBrowser from maven property is "+System.getProperty("WebBrowser"));
        if(System.getProperty("WebBrowser").equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
            driver = new ChromeDriver();
        }if(System.getProperty("WebBrowser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.addArguments("headless");
            driver = new ChromeDriver(chromeoptions);

        }*/
        /*
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        System.out.println("path assigned");
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("headless");
        WebDriver driver = new ChromeDriver(chromeoptions);*/
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("driver started");
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver driverclose(WebDriver driver){
        System.out.println("Entered quite method");
        driver.quit();
        System.out.println("exit done");

        return driver;
    }

    public String getProperty(String strPropertyKey) throws IOException {
        System.out.println("entered in to getProperty method");
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sudha\\IdeaProjects\\SeleniumE2EProject\\src\\main\\resources\\GlobalProperties.properties");
        prop.load(file);
        String strvalue = prop.getProperty(strPropertyKey).trim();
        return strvalue;
    }

    public String getScreenshot(WebDriver driver,String strtestCaseName) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
        TakesScreenshot schreeshot = (TakesScreenshot) driver;
        log.info("schreeshot is "+schreeshot);
        File srcfile=schreeshot.getScreenshotAs(OutputType.FILE);
        log.info("srcfile is "+srcfile);
        String strdestinationFilePath = System.getProperty("user.dir")+"\\reports"+"\\"+strtestCaseName+formater.format(calendar.getTime())+".png";
        log.info("strdestinationFilePath is "+strdestinationFilePath);
        FileUtils.copyFile(srcfile, new File(strdestinationFilePath));
        return strdestinationFilePath;

    }
}
