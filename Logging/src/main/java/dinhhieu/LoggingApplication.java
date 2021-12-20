package dinhhieu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dinhhieu.service.DevideService;
import dinhhieu.service.LogService;


@SpringBootApplication
public class LoggingApplication {
	
	private static Logger logger = LoggerFactory.getLogger(LoggingApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LoggingApplication.class, args);
		    logger.info("Đây là log của hàm main");
		    logger.info("debug enabled: {}", logger.isDebugEnabled());
		    logger.trace("trace");
		    logger.debug("debug");
		    logger.info("info");
		    logger.warn("warn");
		    logger.error("error");
		    LogService service = applicationContext.getBean(LogService.class);
		    service.logfile();
		    
		    DevideService devide = applicationContext.getBean(DevideService.class);
		    devide.devide(4, 0);
	
	}

}
