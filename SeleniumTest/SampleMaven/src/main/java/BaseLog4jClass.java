import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.FactoryConfigurationError;

public class BaseLog4jClass {

    static Logger logger = LogManager.getLogger(BaseLog4jClass.class.getName());

    public boolean check(){
        try{
            DOMConfigurator.configure(this.getClass().getClassLoader().getResource("log4j2.xml"));
            //DOMConfigurator.configure("log4j2.xml");
            logger.info("into the method");
        } catch (FactoryConfigurationError factoryConfigurationError) {
            factoryConfigurationError.printStackTrace();
        }
        return true;
    }

    }
