import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sudha\\IdeaProjects\\SeleniumTest\\TestNG\\data.properties");
        prop.load(file);
        prop.getProperty("browser");
        prop.getProperty("URL");
        System.out.println(prop.getProperty("browser"));
        prop.setProperty("browser","firefox");
        System.out.println(prop.getProperty("browser"));
        FileOutputStream fout = new FileOutputStream("C:\\Users\\sudha\\IdeaProjects\\SeleniumTest\\TestNG\\data.properties");
        prop .store(fout,null);


    }
}
