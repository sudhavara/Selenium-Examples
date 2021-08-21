import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports {

    com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();

    @BeforeTest
    public void ExtendConfig(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        System.out.println("path is"+path);
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("WebAutomationResults");
        reporter.config().setDocumentTitle("SeleniumTestResults");

        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Sudha Rani");
    }

    @Test
    public void BrowserInvocation(){
        extent.createTest("Browser Invocation");
       // System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://instacart.com");
        System.out.println(driver.getTitle());
        driver.quit();
        extent.flush();

    }


}
