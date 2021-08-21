import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listener implements ITestListener {

    public void onStart(ITestContext arg){
        System.out.println("Starts Test Execution....."+ arg.getName());
    }
    public void onFinish(ITestContext arg){
        System.out.println("Finish Test Execution....."+ arg.getName());
    }
    public void onTestStart(ITestContext arg){
        System.out.println("Strat Test Execution....."+ arg.getName());
    }
    public void onTestSkipped(ITestContext arg){
        System.out.println("Skipped Test Execution....."+ arg.getName());
    }
    public void onTestSuccess(ITestContext arg){
        System.out.println("Skipped Test Execution....."+ arg.getName());
    }
    public void onTestFailure(ITestContext arg){
        System.out.println("Failed Test Execution....."+ arg.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestContext arg){
        System.out.println("onTestFailedButWithinSuccessPercentage Test Execution....."+ arg.getName());
    }
}
