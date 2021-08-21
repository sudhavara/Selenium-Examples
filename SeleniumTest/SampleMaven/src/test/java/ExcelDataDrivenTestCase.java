import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ExcelDataDrivenTestCase {

    @Test

    public void dataTestcase() throws IOException {

        ExcelDataDrivenTest datadrive = new ExcelDataDrivenTest();
        List<Object> datarray = datadrive.getexceldata("Employees","Employee Name","Sitaram");
        System.out.println("data for zeo index"+datarray.get(0));
        System.out.println("data for zeo index"+datarray.get(1));
        System.out.println("data for zeo index"+datarray.get(2));
        System.out.println("data for zeo index"+datarray.get(3));


    }

}
