package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicWebTableTestcase {

    WebDriver driver;

    @BeforeTest
    public void driverInitiate(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test

    public void webTableData() throws InterruptedException {
        driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
        driver.manage().window().maximize();
        WebElement next = driver.findElement(By.xpath("//a[@id='example_next']"));
        ArrayList namesList = new ArrayList();
        String strname="";
        while(next.isEnabled()){
            List<WebElement> pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));
            System.out.println("pages count is "+pages.size());
            int icount =0;
            for(int p =0;p<pages.size();p++){
                System.out.println("Page number is "+p);
                WebElement active = driver.findElement(By.xpath("//a[@class='paginate_button current']"));
                active.click();
                Thread.sleep(2000);

                List<WebElement> names = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
                System.out.println("names size is "+names.size());
                for(WebElement name:names){
                    System.out.println("names are "+name.getText());
                    strname=name.getText();
                    namesList.add(name);
                }
                next = driver.findElement(By.xpath("//a[@id='example_next']"));
                next.click();
                Thread.sleep(2000);
                icount++;

            }
            System.out.println("icount is "+icount);
            if(driver.findElement(By.xpath("//a[@class='paginate_button next disabled']")).isEnabled()){
                break;
            }/*
            if(icount==pages.size()){
                break;

            }*/

        }
        System.out.println("names list size is "+namesList.size());
        System.out.println("names list is "+namesList);

        WebElement tableInfo  = driver.findElement(By.xpath("//div[@id='example_info']"));
        String strtableInfo = tableInfo.getText();
        String[] stratbleArray= strtableInfo.split(" ");
        String strtotalcnt = stratbleArray[5];
        int itotalcount = Integer.parseInt(strtotalcnt);
        System.out.println("table count is "+strtotalcnt);

        Assert.assertEquals(itotalcount,namesList.size());
    }

    @AfterTest

    public void driverClose(){
        driver.quit();
    }

}
