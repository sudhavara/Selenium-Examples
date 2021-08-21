package Package1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggertest {

    static Logger logger = LogManager.getLogger(loggertest.class);

    public static void main(String[] args) {
        logger.info("hey i am here");
        logger.error("error message this is");
        logger.fatal("fatal message");
        logger.debug("this is debug message");



    }
}
