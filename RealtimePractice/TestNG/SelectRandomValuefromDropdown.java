package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;

public class SelectRandomValuefromDropdown {

    @Test
    public void selectOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
        int skillOptionCnt = driver.findElements(By.xpath("//select[@id='Skills']/option")).size();
        System.out.println("skillOptionCnt is "+skillOptionCnt);
        Select select= new Select(skills);
        Random random = new Random();
        select.selectByIndex(random.nextInt(skillOptionCnt));
        Thread.sleep(5000);
        driver.quit();

    }

}
