package project.besp.MegaTravel.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class LoggingServiceImpl implements ApplicationRunner{

	private static Logger logger = LogManager.getLogger(LoggingServiceImpl.class);
 
        //SpringApplication.run(LoggingServiceImpl.class, args);
   
	
	public LoggingServiceImpl(Object object){
		logger = LogManager.getLogger(object.getClass());
		
		logger.debug("Debugging log");
	    logger.info("Info log");
	    logger.warn("Hey, This is a warning!");
	    logger.error("Oops! We have an Error. OK");
	    logger.fatal("Damn! Fatal error. Please fix me.");
    }
	
	public void printInfo(String message){
        try{
            logger.info(message);
        }catch(Exception e){
            System.out.println("Logger does not work");
        }
    }
	
	public void printError(String message){
        try{
            logger.error(message);
        }catch(Exception e){
            System.out.println("Logger does not work");
        }
    }
	
	public void printWarning(String message){
        try {
            logger.warn(message);
        }catch (Exception e){
            System.out.println("Logger does not work");
        }
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		  logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Hey, This is a warning!");
	        logger.error("Oops! We have an Error. OK");
	        logger.fatal("Damn! Fatal error. Please fix me.");
	        
	        
		
	}
	
}
