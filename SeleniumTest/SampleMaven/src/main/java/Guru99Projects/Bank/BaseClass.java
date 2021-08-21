package Guru99Projects.Bank;

import org.openqa.selenium.WebDriver;

public class BaseClass implements BankInterface {
    WebDriver driver=null;
    BasePage basePage = new BasePage();

    LoginPage loginPage = new LoginPage();
    public static void main(String[] args){


    }

    @Override
    public WebDriver basePage() {

        basePage.driverIniation();
        System.out.println("driver started");
        basePage.driverClose();

        return null;
    }

    @Override
    public WebDriver loginPage() {

        loginPage.getUserId(driver);
        loginPage.getpassword(driver);
        return null;
    }
}
