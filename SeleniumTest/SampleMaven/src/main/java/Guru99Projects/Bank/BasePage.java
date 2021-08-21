package Guru99Projects.Bank;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class BasePage  {
    WebDriver driver;
    public static final String BASE_URL = "http://www.demo.guru99.com/";
    public static final String EXPECT_TITLE = "Guru99 Bank Home Page";
    public static void main(String[] args) throws InterruptedException {
        BasePage basepage = new BasePage();
        basepage.driverIniation();
        System.out.println("done iniation");
    }



    public WebDriver driverIniation(){
        System.setProperty("webdriver.gecko.driver", "D:\\SeleniumUdemy\\MozillaDriver\\geckodriver.exe");
        System.out.println("propert set for driver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();


        return driver;

    }

    public void driverClose(){

        driver.quit();
    }


    public String[][] getExcelData(String strFilePath,String strSheetName) throws IOException {
        FileInputStream fis = new FileInputStream(strFilePath);
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        ArrayList<String> userList = new ArrayList<String>();
        String tableData [][]=null;
        int inumSheets =workBook.getNumberOfSheets();
        Sheet sheet = workBook.getSheet(strSheetName);

        Iterator<Row> rows = sheet.iterator();

        for(int i=0;i<1;i++) {
            int itotalRows = sheet.getPhysicalNumberOfRows();
            System.out.println("total rows " + itotalRows);
            int itotalColumn = sheet.getRow(i).getPhysicalNumberOfCells();
            System.out.println("total columns " + itotalColumn);
            tableData = new String[itotalRows][itotalColumn];


            for (int r = 0; r < itotalRows; r++) {
                 Row row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 1; c < itotalColumn; c++) {
                         Cell cell = row.getCell(c);
                        System.out.println("cell value is " + cell.getStringCellValue());
                        if (cell != null) {
                            if (cell.getCellType() == CellType.STRING) {
                                //need to write code here
                                tableData[r][c] = "" + cell.getStringCellValue();
                            }if(cell.getCellType() == CellType.NUMERIC){
                                int icellStringdata = (int)(cell.getNumericCellValue());
                                tableData[r][c] = ""+String.valueOf(icellStringdata);
                            }

                            System.out.println("cell data is " + tableData[r][c]);

                        }

                    }
                }
            }
        }


        /*
        for(int i =ifirstRow;i<lastRow;i++){
            while(rows.hasNext()){
                Row nextRow = rows.next();
                System.out.println("next row value is "+nextRow);
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                int k =0;
                int columnIndex =0;
                while(cellIterator.hasNext()){
                    Cell nextCell = cellIterator.next();
                    System.out.println("cell value is "+nextCell);
                    //userList.add((nextCell).toString());                sheet.getCell
                }

            }

        }*/

        workBook.close();
        fis.close();
       return tableData;


    }

public String getscreenShot(WebDriver driver,String strtestCaseName) throws IOException {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat Dateformat = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    System.out.println("schreeshot is "+screenshot);
    File scrrenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
    System.out.println("screenshot file is "+scrrenshotFile);
    FileInputStream fis = new FileInputStream(scrrenshotFile);
    //String strdestinationFilePath = "C:\\Users\\sudha\\IdeaProjects\\SeleniumE2EProject\\reports";
    String strdestinationFilePath = System.getProperty("user.dir")+"\\reports"+"\\"+strtestCaseName+"_"+Dateformat.format(calendar.getTime())+".png";
    System.out.println("destination path is "+strdestinationFilePath);
    FileUtils.copyFile(scrrenshotFile,new File(strdestinationFilePath));
    return strdestinationFilePath;




}


}
