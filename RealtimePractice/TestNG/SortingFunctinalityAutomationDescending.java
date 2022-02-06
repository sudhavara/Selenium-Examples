package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingFunctinalityAutomationDescending {
    WebDriver driver;
    ArrayList<Double> UnsortedPriceList;
    ArrayList<Double> SortedPriceList;



    @BeforeTest
    public void driverInitaetion(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void loginSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#login-button")).submit();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods ={"loginSauce"})
    public void sortProductsPrice() throws InterruptedException {
        WebElement prodcutsSortContainer = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(prodcutsSortContainer);
        select.selectByValue("hilo");
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = {"loginSauce"})
    public void getInventoryPriceListActual() throws InterruptedException {
        System.out.println("Entered in to getInventoryPriceListActual method");
        UnsortedPriceList = getInventoryPriceList();
        System.out.println("Unsorted arraylist is "+UnsortedPriceList.toString());

    }

    @Test (dependsOnMethods = {"sortProductsPrice"})
    public void getInventoryPriceListSorted() throws InterruptedException {
        System.out.println("Entered in to getInventoryPriceListSorted method");
        SortedPriceList = getInventoryPriceList();
        System.out.println("Sorted arraylist is "+SortedPriceList.toString());

    }


    public ArrayList<Double> getInventoryPriceList() throws InterruptedException {

        List<WebElement> inventorynamesList = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
        System.out.println("inventry list size is "+inventorynamesList.size());
        ArrayList<Double> sortedPriceList = new ArrayList();
        for(int i=1; i<=inventorynamesList.size();i++){
            System.out.println("inventry price for item  "+i);
            WebElement pricebar = driver.findElement(By.xpath("//div[@class='inventory_list']/div["+i+"]/div[2]//div[@class='pricebar']//div[@class='inventory_item_price']"));
            String strpricebar = pricebar.getText();
            Double Price = Double.parseDouble(strpricebar.replace("$",""));
            sortedPriceList.add(Price);
            System.out.println("Price is "+Price);
            Thread.sleep(2000);
        }
        System.out.println("Pricearray list is "+sortedPriceList.toString());

        return sortedPriceList;

    }

    @Test (dependsOnMethods = {"getInventoryPriceListActual","getInventoryPriceListSorted"})
    public void comparePriceList(){
        System.out.println("Entered in to comparePriceList method");
        System.out.println("UnsortedPriceList is "+UnsortedPriceList.toString());
        System.out.println("SortedPriceList is "+SortedPriceList);
        /*
        Collections.sort(UnsortedPriceList);
        Collections.reverse(UnsortedPriceList);*/
        Collections.sort(UnsortedPriceList,Collections.reverseOrder());
        System.out.println("after sorting expected unsorted arraylist is "+UnsortedPriceList.toString());
        Assert.assertEquals(UnsortedPriceList,SortedPriceList);

    }


    @Test(dependsOnMethods = {"comparePriceList"})
    public void tearDown(){
        driver.quit();
    }
}
