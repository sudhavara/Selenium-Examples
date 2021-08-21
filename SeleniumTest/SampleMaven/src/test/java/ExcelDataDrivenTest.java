import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataDrivenTest {

    public static void main(String[] args) throws IOException {

        List<Object> datalist = getexceldata("Employees","Employee Name","Srivatsa");
        System.out.println("datalist is "+datalist);

    }


        public static List<Object> getexceldata(String strsheetname, String strcloumnname, String strrowname) throws IOException
    {
            List<Object> arraydata = new ArrayList<Object>();
            FileInputStream file = new FileInputStream("D:\\SeleniumUdemy\\EmployeeData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            int iSheetNumber = workbook.getNumberOfSheets();
            System.out.println("iSheetNumber" + iSheetNumber);
            for (int i = 0; i < iSheetNumber; i++) {
                String strSheetname = workbook.getSheetName(i);
                System.out.println("strSheetname is" + strSheetname);
                if (strSheetname.equalsIgnoreCase(strsheetname)) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                    System.out.println("rows are" + rows);
                    Row firtsrow = rows.next();
                    Iterator<Cell> ce = firtsrow.cellIterator();
                    int k = 0;
                    int columnindex = 0;
                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        System.out.println("cell calue is " + value);
                        if (value.getStringCellValue().equalsIgnoreCase(strcloumnname)) {
                            columnindex = k;
                        }
                        k++;

                    }
                    System.out.println("columnindex" + columnindex);
                    while (rows.hasNext()) {
                        Row r = rows.next();
                        //System.out.println("row value is"+r);
                        if (r.getCell(columnindex).getStringCellValue().equalsIgnoreCase(strrowname)) {
                            System.out.println("column index value is "+r.getCell(columnindex).getStringCellValue() );
                            Iterator<Cell> matchedcell = r.cellIterator();
                            System.out.println(" matchedcell is "+matchedcell);
                            while (matchedcell.hasNext()) {
                                Cell data = matchedcell.next();
                                System.out.println("data is "+data);
                                System.out.println("matchedcell next data is there");
                                System.out.println("data type is "+data.getCellType()+"for data"+data);
                                if (data.getCellType() == CellType.NUMERIC) {
                                    System.out.println("data type is numeric");
                                    System.out.println(data.getNumericCellValue());
                                    int icellStringdata = (int) data.getNumericCellValue();
                                    arraydata.add(icellStringdata);

                                } else if (data.getCellType() == CellType.STRING) {
                                    System.out.println("data type is String");
                                    System.out.println(data.getStringCellValue());
                                    String stringcelldata = data.getStringCellValue();
                                    arraydata.add(stringcelldata);
                                }


                            }
                        }

                    }

                }
            }

            return arraydata;


        }
    }

