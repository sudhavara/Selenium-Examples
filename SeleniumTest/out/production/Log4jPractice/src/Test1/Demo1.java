package Test1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo1 {

    private static Logger Log4j = LogManager.getLogger(Demo1.class.getName());
    public static void main(String[] arg){


            Log4j.info("log message");
                Log4j.debug("debug message");
        Log4j.error("error message");


    }
}
