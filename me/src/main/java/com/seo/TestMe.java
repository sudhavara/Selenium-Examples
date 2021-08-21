package com.seo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMe {

       static Logger logger= LogManager.getLogger(TestMe.class);
    public static void main(String[] args) {
        logger.info("hey i am here");
        System.out.println("done logging");
    }
}
