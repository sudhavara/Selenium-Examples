package SeleniumInterviewPreparation;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritedatatoExcel {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Employee Data");
        Object empData[][] = {{"Name", "ID", "JOB"},
                              {"101", "Jak", "Engineer"},
                              {"102", "Ram", "Doctor"},
                              {"103", "Vatsa", "Astronaut"}};
        int rowCount =0;
        int columnCount=0;
        for(Object data[]:empData){
            XSSFRow row = sheet.createRow(rowCount++);

            for(Object value:empData){

                XSSFCell cell =row.createCell(columnCount++);
                if(value instanceof String){
                    cell.setCellValue((String)value);

                }
                if(value instanceof Integer){
                    cell.setCellValue((Integer)value);
                }

            }
        }
        String strFilepath = "D:\\SeleniumUdemy\\DatadriveTesting\\employeeData.xlsx";
        FileOutputStream fou=new FileOutputStream(strFilepath);
        workBook.write(fou);
        fou.close();
        System.out.println("EXcel file written successfully");



    }
}
