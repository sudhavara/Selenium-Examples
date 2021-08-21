import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment6 {

    public static void doMe(List<WebElement> checkboxlist, int i) {
        if (i >=0) {
            if (checkboxlist.get(i).isSelected()) {
                checkboxlist.get(i).click();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }

            }
            doMe(checkboxlist, i - 1);
        }
        return;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement checkboxoption = driver.findElement(By.xpath("//div[@class='right-align']/fieldset[1]/label[2]"));
        checkboxoption.click();
        String strcheckboxmessage = checkboxoption.getText();
        System.out.println("message is " + strcheckboxmessage);
        WebElement checkboxdriver = driver.findElement(By.xpath("//div[@id='checkbox-example']"));
        int size = checkboxdriver.findElements(By.tagName("label")).size();
        System.out.println("checkbox size is " + size);
        List<WebElement> checkboxlist = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //WebElement checkbox = driver.findElement(By.cssSelector("//input[@contains(id='checkBoxOption)']"));
        int j = 1;
        for (int i = 0; i < checkboxlist.size(); i++) {
            if (i >= 1) {
                doMe(checkboxlist, i);
            }
            checkboxlist.get(i).click();
            String strmessage = checkboxlist.get(i).getAttribute("value");
            System.out.println("Checkbox message is" + strmessage);
            WebElement dropdownelement = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
            Select selectdrop = new Select(dropdownelement);
            selectdrop.selectByValue(strmessage);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input#name")).sendKeys(strmessage);

            driver.findElement(By.cssSelector("input#alertbtn")).click();
            driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        }

        Thread.sleep(2000);

        driver.quit();

    }


}

