package Package2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggertest1 {

    static Logger logger = LogManager.getLogger(loggertest1.class);

    public static void main(String[] args) {
        logger.info("hey i am here");
        logger.error("error message this is");
        logger.fatal("fatal message");
        logger.debug("this is debug message");



    }
}
