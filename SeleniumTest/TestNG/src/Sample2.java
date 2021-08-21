import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample2 {
    @Parameters({"URL","UserName"})
    @Test

    public void bankTestCaseLogin(String urlname,String key){
        System.out.println("This is bank test case");
        System.out.println("URL value is "+urlname);
        System.out.println("user id is"+key);
    }

    @Test
    public void HomeTestLogin(){
        System.out.println("Thhis is homne tst login case");
    }

    @Test
    public void HomeTestLogout(){
        System.out.println("Thhis is homne tst logout case");
    }

}
