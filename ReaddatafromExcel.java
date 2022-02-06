package SeleniumInterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaddatafromExcel {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\SeleniumUdemy\\EmployeeData.xlsx");


        //FileInputStream fio = new FileInputStream("D:\\SeleniumUdemy\\EmployeeData.xlsx");
        //XSSFWorkbook workBook = new XSSFWorkbook(fio);
        FileInputStream fio = new FileInputStream(file.getAbsolutePath());

        XSSFWorkbook workBook = new XSSFWorkbook(fio);
        int iSheetNumber = workBook.getNumberOfSheets();
        System.out.println("iSheetNumber" + iSheetNumber);
        XSSFSheet sheet1 = workBook.getSheetAt(0);
        int rowccount = sheet1.getLastRowNum();
        int column = sheet1.getRow(1).getLastCellNum();
        System.out.println("Lats row wnumber is "+ rowccount);
        for(int i=0;i<rowccount;i++){
            XSSFRow row = sheet1.getRow(i);
            for( int j=0;j<column;j++){
                XSSFCell cell = row.getCell(j);

                switch(cell.getCellType()){

                    case STRING :
                        System.out.print(cell.getStringCellValue());
                        break;

                    case NUMERIC :
                        System.out.print(cell.getNumericCellValue());;
                        break;

                    case BOOLEAN :
                        System.out.print(cell.getBooleanCellValue());
                        break;

                }

                System.out.print("|");


            }

            System.out.println();
        }


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

    }
}
