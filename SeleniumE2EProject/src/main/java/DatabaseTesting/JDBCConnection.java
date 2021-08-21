package DatabaseTesting;

import com.mysql.jdbc.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnection {

    public static Logger log= LogManager.getLogger(JDBCConnection.class.getName());

    public static void main(String[] args) throws SQLException, InterruptedException {
        String host = "localhost";
        String port="3306";
        Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+3306+"/qadbt","root","root");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from employeedata where emp_loc='SujataNagar';");

        List empnamelist = new ArrayList();

        while(rs.next()) {
           // log.info("Employee ID "+rs.getString("emp_id"));
            //log.info("Employee NAme is "+rs.getString("emp_name"));
            //log.info("employee location is "+rs.getString("emp_loc"));
            //log.info("Employee age "+rs.getInt("emp_age"));

            empnamelist.add(rs.getString("emp_name"));


             //log.info("employee names sizecare" +empnamelist.size());

        }
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");


        for(int i=0;i<empnamelist.size();i++){
            log.info("employee names are" +empnamelist.get(i));
            driver.findElement(By.cssSelector("input#username")).sendKeys(empnamelist.get(i).toString());
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input#password")).sendKeys("password");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input#Login")).click();


        }

        driver.quit();




    }



}

