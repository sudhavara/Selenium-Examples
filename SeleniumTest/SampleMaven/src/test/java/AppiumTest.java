
import org.testng.Assert;
import org.testng.annotations.Test;

//@RunWith(value = TestN.class)
public class AppiumTest  {
    @Test
    public  void AppiumTest(){
        System.out.println("AppiumTest");
        ProcessUrl url=new ProcessUrl();
        Assert.assertEquals(url.getUrl(null),"me");
        //Assert.assertEquals(url.getUrl("meeemememme"),"me");
        /*
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("www.google.com");*/
    }

    @Test

    public void IOSApps(){
        System.out.println("IOSApps");
    }
}
