package SeleniumInterviewPreparation.RealtimePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PaginationDynamicTable {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
        driver.manage().window().maximize();
        WebElement selectLength = driver.findElement(By.xpath("//div[@id='example_length']/label/select"));
        Select select = new Select(selectLength);
        select.selectByValue("10");
        Thread.sleep(2000);
        /*


        String strdisplayTableCnt= driver.findElement(By.xpath("//div[@id='example_info']")).getText();
        String substrdisplayTableCnt = strdisplayTableCnt.substring(strdisplayTableCnt.indexOf("f")+1,strdisplayTableCnt.indexOf("e")-1);
        System.out.println("Count substring is "+substrdisplayTableCnt.trim());*/
        //Check the pagination

        WebElement nextButton = driver.findElement(By.xpath("//a[@id='example_next']"));
        while (nextButton.isEnabled()) {
            /*
            List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"));
            for(WebElement columnname:columnNames){
                System.out.println("Columns names are "+columnname.getText());

            }*/
            Thread.sleep(2000);
            System.out.println("Checking for next step count of rows on every page");
            List<WebElement> nextpages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a[@aria-controls='example']"));
            ArrayList<WebElement> nextarrayList = new ArrayList<WebElement>(nextpages);

            int index = 1;

            //document.querySelectorAll("#example_paginate>span>a");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            int itotalrowCount =0;
            for (int i = 0; i < nextpages.size(); i++) {
                System.out.println("entered in to for loop for index "+ i);
                nextpages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a[@aria-controls='example']"));
                System.out.println("nextpage index is " + nextpages.get(i).getAttribute("data-dt-idx"));
                WebDriverWait wait = new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='example_paginate']/span/a[@aria-controls='example']")));
                try {
                    js.executeScript("window.scrollBy(0,100)");
                    //js.executeScript("arguments[0].scrollIntoView(true);", nextpages.get(i));
                    nextpages.get(i).click();
                    //find the rows
                    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
                    itotalrowCount= itotalrowCount+rows.size();
                    List<WebElement> employeeNamesList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
                    /*
                    for(WebElement name:employeeNamesList){
                        System.out.println("employeeNames are for page index " +i + " are " +name.getText());
                    }*/
                    //checking the only software engineer position names
                    List<WebElement> positions = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
                    int imatchRowNum =0;
                    for(int p =0;p<positions.size();p++){

                        //System.out.println("position names are "+positions.get(p).getText());
                        if(positions.get(p).getText().equals("Software Engineer")){
                            System.out.println("Entered in to software posoition list");
                            imatchRowNum =p;
                            WebElement SEEmployeeName = driver.findElement(By.xpath("//tbody/tr["+(p+1)+"]/td[1]"));
                            System.out.println("Matched employee name is "+SEEmployeeName.getText());


                        }
                    }


                }catch(StaleElementReferenceException ste){
                    js.executeScript("window.scrollBy(0,50)");
                    //js.executeScript("arguments[0].scrollIntoView(true);", nextpages.get(i));
                    nextpages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a[@aria-controls='example']"));

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='example_paginate']/span/a[@aria-controls='example']")));
                    nextpages.get(i).click();
                }
                System.out.println("Page clicked ");
                Thread.sleep(2000);


                index++;
            }
            System.out.println("Total row count is "+itotalrowCount);
            System.out.println("index value is "+index);
            if(index==nextpages.size()+1){
                break;
            }
        }
        driver.quit();

    }
}

 /*

                WebElement nextlink = driver.findElement(By.cssSelector("#example_paginate >span >a:nth-child("+index+")"));
                nextlink.click();
                System.out.println("next button clicked");
                if(i==2){
                    driver.findElement(By.cssSelector("#example_paginate >span >a:nth-child(3)")).click();
                    System.out.println("clicked for 3rd page");
                }
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", nextlink);
                System.out.println("Scrolled till element found");
                Thread.sleep(500);
                try {
                    js.executeScript("arguments[0].click();",nextlink);

                    System.out.println("Element found and clicked");
                }catch(StaleElementReferenceException ste){
                    nextlink = driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]"));
                    js.executeScript("arguments[0].click();",nextlink);
                    System.out.println("Element found and clicked in catch block");
                    if(i==2){
                        driver.findElement(By.cssSelector("#example_paginate >span >a:nth-child(3)")).click();
                        System.out.println("clicked for 3rd page in catch");
                    }
                }
                index++;
                */



















