package Guru99Projects.Bank;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Guru99Projects.Bank.BasePage.BASE_URL;
import static Guru99Projects.Bank.BasePage.EXPECT_TITLE;

public class LoginPageTest extends BaseClass{

    public static Logger log =  LogManager.getLogger(LoginPageTest.class.getName());
    WebDriver driver =null;
    private Object[][] UserData;
    String username="";
    String  password="";
    String strFilePath = "";
    String strSheetName ="";

    @BeforeTest
    public void browserInvoation(){
       driver = basePage.driverIniation();
        log.info("driver initiation done");


    }

    @Test
    public void validateTitle(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL + "/V4/");
        String strActualTitle = driver.getTitle();
        System.out.println("actual title is "+strActualTitle);
        String strExpectedTitle = "Guru99 Bank Home Page";
        Assert.assertEquals(strActualTitle,EXPECT_TITLE);
        System.out.println("Title matched");

    }

    @Test(dataProvider= "GuruTest")
    public void loginValidation(String bad, String username,String password) throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL + "/V4/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        loginPage.getUserId(driver).sendKeys(username);
        loginPage.getpassword(driver).sendKeys(password);
        loginPage.getlogIn(driver).click();
        Thread.sleep(1000);
        String strloginActualTitle = driver.getTitle();
        System.out.println("login title is "+strloginActualTitle);
        String strExpectedloginTitle = "Guru99 Bank Manager HomePage";
        if(strExpectedloginTitle.equals(strloginActualTitle)){
            Assert.assertEquals(strloginActualTitle,strExpectedloginTitle,"Titles of the login do not match");
            basePage.getscreenShot(driver,"loginValidation");
            System.out.println(loginPage.getmanagerIdmessage(driver).getText());
            System.out.println(loginPage.getwelcomeMessage(driver).getText());
            String strExpectedManagerusrText= "Manger Id :"+" "+username;
            String strActualManagerusrText = loginPage.getmanagerIdmessage(driver).getText();
            Assert.assertEquals(strExpectedManagerusrText,strActualManagerusrText,"Manager Welocme Text Matched");
            basePage.getscreenShot(driver,"loginManagerTextValidation");

        }else{
            System.out.println("enterd else block");
            WebElement alert =driver.findElement(By.xpath("//script[@contains(text(),'alert')]"));
            //td[@contains(text(),'Manager')]
            System.out.println("element found");



        }


        driver.navigate().back();


        }



    public static boolean isAlertPresent(WebDriver driver,String strusername,String stpassword){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().sendKeys(strusername+ Keys.TAB+stpassword);

            return true;
        }catch(NoAlertPresentException ex){
            return false;

        }

    }

    @DataProvider(name = "GuruTest")
    public Object[][] guruTest() throws IOException {
        Object[][] userData = null;
        strFilePath ="D:\\SeleniumUdemy\\Guru99Data\\Guru99UserData.xlsx" ;
        strSheetName="UserDetails";
        userData= basePage.getExcelData(strFilePath,strSheetName);
        return userData;

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
