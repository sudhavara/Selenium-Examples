import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener.class)
public class TestNGSample {

    @Test(dataProvider = "getData")
    public void Demo1Login(String username,String password){

        System.out.println("This is demo1 login testcase1");
        System.out.println("username is "+username);
        System.out.println("password is "+password);
    }
    @Test(dataProvider = "getData")
    public void Demo2Logout(String username,String password){
        System.out.println("This is demo2 login testcase2");
        System.out.println("username is "+username);
        System.out.println("password is "+password);
    }

    @Test(dataProvider = "getData")
    public void register(String username,String password){
        System.out.println("This is register testcase");
        System.out.println("username is "+username);
        System.out.println("password is "+password);
    }
    @DataProvider
    public Object[][] getData(){
        Object [] [] data =new Object[3][2];
        data[0][0]="first set username";
        data[0][1]="first set password";
        data[1][0] = "secondset username";
        data[1][1]="secondset password";
        data[2][0]="tjirdset username";
        data[2][1]="thirdset passowrd";
        return data;
    }


}


