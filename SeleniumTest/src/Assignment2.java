import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Assignment2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver,5);
        Thread.sleep(20000);
        //radio button
        driver.findElement(By.xpath("//div[@class='flex flex-between flex-middle px-4 mt-2 mb-4']/label[2]/div[1]/span")).click();

        driver.findElement(By.xpath("//h4[text()='Depart on']")).click();



       // driver.findElement(By.cssSelector("div.App.flex.flex-column div.container.w-100p.flex-1:nth-child(2) div.row div.col-13.homeba div.bg-white.p-32.mt-10 div.row.pt-3.pb-6.p-relative.px-4:nth-child(5) div.row.pl-4.pr-4.p-relative div.col.flex.flex-middle div.flex.flex-middle.p-relative.homeCalender div.bg-white.br-4.elevation-5.p-1.p-absolute.mt-1.z-50.l-0.t-8:nth-child(4) div.DayPicker.w-100p.Selectable div.DayPicker-wrapper div.DayPicker-Months div.DayPicker-Month:nth-child(1) div.DayPicker-Body div.DayPicker-Week:nth-child(3) div.DayPicker-Day.DayPicker-Day--start.DayPicker-Day--end.DayPicker-Day--selected.DayPicker-Day--today:nth-child(3) div.Day-grid.flex.flex-middle.flex-column.flex-center > div.p-1.day-gridContent.flex.flex-middle.flex-column.flex-center.Round-trip")).click();
        //select the passengers count checkbox
        String stradults;
        WebElement element = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/h4[1]"));
        System.out.println("Element data is "+element.getText());
        if(element.getText().equalsIgnoreCase("Adults")){
            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]/option[6]")).click();
            Thread.sleep(2000);
        }
        WebElement Children = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/h4[1]"));
        System.out.println("Element data is "+Children.getText());
        if(Children.getText().equalsIgnoreCase("Children")){

            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/select[1]/option[3]")).click();
            Thread.sleep(2000);
        }
        WebElement infants = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[5]/h4[1]"));
        System.out.println("infants data is "+infants.getText());

        if(infants.getText().equalsIgnoreCase("Infants")){

            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[5]/select[1]/option[2]")).click();
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        //Move to next step economy or class
        driver.findElement(By.xpath("//strong[@class='pr-1']")).click();


        driver.findElement(By.xpath("//option[@value='First']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("Del");
        List<WebElement> airlineslist = driver.findElements(By.xpath("//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']"));
        System.out.println("airlines size is"+airlineslist.size());
        for(WebElement airlines :airlineslist){


            if(airlines.getText().equalsIgnoreCase("Delta (DL)")){
                System.out.println("airlines matched is "+airlines.getText());
                airlines.click();
                Thread.sleep(20000);
                break;

            }


        }
        driver.findElement(By.xpath("//div[@class='col flex flex-middle']/button")).click();
        Thread.sleep(2000);

        //to display alert
driver.findElement(By.cssSelector("span[class='to-ellipsis o-hidden ws-nowrap fs-3 c-white']")).click();
        System.out.println(driver.switchTo().alert().getText());



        driver.quit();

    }
}
