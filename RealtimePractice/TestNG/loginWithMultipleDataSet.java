package SeleniumInterviewPreparation.RealtimePractice.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class loginWithMultipleDataSet {

    WebDriver driver;

    @Test
    public void driverInitiation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void loginApp() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("user1");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#Password")).sendKeys("password1");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).submit();
        Thread.sleep(2000);
    }

    @Test
    public void dataProvider() throws IOException, InvalidFormatException {
        List<Object> excelData = getuserdatafromExcel();
        for(int i=1;i<excelData.size();i++) {
            System.out.println("data for zeo index " + excelData.get(0).toString());



        }


    }


    public List<Object> getuserdatafromExcel() throws IOException, InvalidFormatException {

        String strFilePath = "D:\\SeleniumUdemy\\LoginUserData.xlsx";

        File file = new File(strFilePath);
        XSSFWorkbook workBook = new XSSFWorkbook(file);

        XSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        String strcellData ;
        double icellData =0.0;

        List<Object> excelArrayData = new ArrayList<Object>();

        while(it.hasNext()){
            XSSFRow row = (XSSFRow) it.next();
            Iterator<Cell> cellIt = row.cellIterator();

            while(cellIt.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIt.next();
                int columnIndex = cell.getColumnIndex();
                switch(cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        strcellData = cell.getStringCellValue();
                        excelArrayData.add(strcellData);
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        icellData = cell.getNumericCellValue();
                        excelArrayData.add(icellData);
                        break;
                }

            }
            System.out.println("ExcelData Array list is "+excelArrayData.toString());

        }
        return excelArrayData;

    }




}
