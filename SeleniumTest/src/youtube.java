import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ListIterator;

public class youtube {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("yt-formatted-string[class='style-scope ytd-button-renderer style-suggestive size-small']")));
        driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-button-renderer style-suggestive size-small']")).click();
        driver.findElement(By.cssSelector("input[id='identifierId']")).click();
        driver.findElement(By.cssSelector("input[id='identifierId']")).sendKeys("");
        driver.findElement(By.cssSelector("div[id='identifierNext']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");

        driver.findElement(By.cssSelector("div[id='passwordNext']")).click();

        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#search")));
        driver.findElement(By.cssSelector("input#search")).sendKeys("telugu love songs");
        //yt-formatted-string[@class='style-scope ytd-video-renderer']
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
        Thread.sleep(5000);
        //div[@id='items']/ytd-video-renderer
        //ytd-item-section-renderer.style-scope.ytd-section-list-renderer
        List<WebElement> list = null;
       List<WebElement> videolinkslist = driver.findElements(By.xpath("//h3[@class='title-and-badge style-scope ytd-video-renderer']/a[1]"));
        Thread.sleep(2000);
        System.out.println("video items list size "+videolinkslist.size());

       for(int i =0;i<videolinkslist.size();i++){
            System.out.println("Entered for loop number "+i);
           System.out.println("video items naemsa rae "+videolinkslist.get(i).getAttribute("title"));
            //WebElement video = videolinkslist.get(i).findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
            System.out.println("song name is "+videolinkslist.get(i).getText());
           videolinkslist.get(i).click();
            System.out.println("videolist clicked for next video");

            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Keys.chord(Keys.CONTROL,Keys.PAGE_DOWN);
            js.executeScript("window.scrollBy(500,document.body.scrollHeight)");
            Thread.sleep(10000);

            WebElement commentsbox = driver.findElement(By.xpath("//ytd-item-section-renderer[@id='sections']/div[1]/ytd-comments-header-renderer[1]"));
            System.out.println("Element found");
            commentsbox.click();
            System.out.println("element clicked");
            Thread.sleep(2000);

            WebElement elem1 =driver.findElement(By.xpath("//ytd-comments-header-renderer[@class='style-scope ytd-item-section-renderer']/div[@id='simple-box']"));
            System.out.println("element found again");
            elem1.click();
            System.out.println("clicked");
            Thread.sleep(2000);
            WebElement actualcomments = driver.findElement(By.xpath("//div[@id='simple-box']/ytd-comment-simplebox-renderer[1]/div[@id='comment-dialog']/ytd-comment-dialog-renderer/ytd-commentbox[1]"));
            System.out.println("actaual comment box found");
            actualcomments.sendKeys("www.teknosys.in");
            System.out.println("done");
            Thread.sleep((2000));
            WebElement commentclick = driver.findElement(By.xpath("//ytd-button-renderer[@id='submit-button']/a"));
            //WebElement commentclick = driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-button-renderer style-primary size-default']"));
            System.out.println("click comment found");

            commentclick.click();
            System.out.println("comment added");
            Thread.sleep(2000);
            driver.navigate().back();
        }
        Thread.sleep(2000);

        driver.quit();


    }
}