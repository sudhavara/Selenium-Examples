import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableStreams {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();
        WebElement company = driver.findElement(By.xpath("//table[@class='dataTable']/thead[1]/tr[1]/th[1]"));
        List<WebElement> companynames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
        List<String> comanynameslist =companynames.stream().map(s->s.getText()).collect(Collectors.toList());
        System.out.println("comanynameslist with ojt sorted is "+comanynameslist);
        System.out.println( "company names list is"+comanynameslist.size() );

        List<String> sortedcomanynameslist = comanynameslist.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedcomanynameslist is" +sortedcomanynameslist);
        System.out.println("sorted list size is "+sortedcomanynameslist.size());
       // Assert.assertTrue(comanynameslist.equals(sortedcomanynameslist));
        Thread.sleep(10000);
        List<String> pricelist = companynames.stream().filter(s->s.getText().contains("Nestle India")).
                map(s->getcurrentPrice(s)).collect(Collectors.toList());
        pricelist.stream().forEach(k-> System.out.println(k));



        WebElement tabledriver = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[4]/a[2]"));
        List<WebElement> groupbcompanylist = tabledriver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td/a[1]"));
        groupbcompanylist.stream().forEach(s-> System.out.println(s.getText()));
        List<String> companylistgroupb = groupbcompanylist.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> CapitalFirstList = companylistgroupb.stream().filter(s->s.contains("Capital")).collect(Collectors.toList());
        CapitalFirstList.stream().forEach(s-> System.out.println(s));

        List<WebElement> groupbpricelist = tabledriver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/following-sibling::td[3]"));
        groupbpricelist.stream().forEach(s-> System.out.println(s.getText()));






        driver.quit();

       // System.out.println();


    }

    private static String getcurrentPrice(WebElement s) {
        String price="";

        price = s.findElement(By.xpath("following-sibling::td[3]")).getText();

        return price;
    }


}
