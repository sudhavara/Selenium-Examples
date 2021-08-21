package E2EProject;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import E2EProject.ExtentReporter;


import java.io.IOException;

public class ListenersTest extends BasePage implements ITestListener {

    public static Logger log = LogManager.getLogger(ListenersTest.class.getName());

    ExtentReports Extent = ExtentReporter.getExtentReports();
    ThreadLocal<ExtentTest> ExtentThreadtestcase = new ThreadLocal<ExtentTest>();
    ExtentTest testcase;

    @Override
    public void onTestStart(ITestResult result)
    {
        testcase = Extent.createTest(result.getMethod().getMethodName());
        ExtentThreadtestcase.set(testcase);
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        ITestListener.super.onTestSuccess(result);
        ExtentThreadtestcase.get().log(Status.PASS,"TestCase passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver;
        log.info("Entered in to failure listeners method");
        ExtentThreadtestcase.get().fail(result.getThrowable());
        ITestListener.super.onTestFailure(result);
        String strresult = result.getMethod().getMethodName();
        log.info("test result is "+strresult);
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            log.info("About to call screen shot method");
            ExtentThreadtestcase.get().addScreenCaptureFromPath(getScreenshot(driver ,strresult),result.getMethod().getMethodName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {

        ITestListener.super.onFinish(context);
        Extent.flush();
    }
}
