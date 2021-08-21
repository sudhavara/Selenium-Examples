package E2EProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    public static ExtentReports getExtentReports () {
        String strreportpath = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(strreportpath);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("FreeCRM WebSite Test Results");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Sudharani Varanasi");
        return extentReports;

    }
}
