import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class ShoppingWeb {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        String[] itemslist = {"Cucumber", "Brocolli", "Beetroot", "Tomato", "Carrot"};
        Thread.sleep(3000);
        addItems(driver,itemslist);
        driver.quit();
    }

        public static  void addItems(WebDriver driver,String[] itemslist){
            System.out.println("entered in to method");
        int selectcount=0;

            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            String strproductname[] = null;
            System.out.println("products size "+products.size());
            for(int i =0;i<products.size();i++){

                strproductname = products.get(i).getText().split("-");
                String stractualproduct = strproductname[0].trim();
                System.out.println("stractualproduct is "+stractualproduct);
                List list = Arrays.asList(itemslist);
                if(list.contains(stractualproduct)){
                    System.out.println("product matchedd"+stractualproduct);

                    selectcount++;

                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    System.out.println("button clicked");

                    if(selectcount==itemslist.length)

                    {

                        break;

                    }

                }


                }



            }





        }




