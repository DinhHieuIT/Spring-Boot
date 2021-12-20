package dinhhieu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dinhhieu.LoggingApplication;

@Service
public class LogService {
	
	private static Logger logger = LoggerFactory.getLogger(LogService.class);
	
	public void logfile() {
		 logger.info("Đây là log của hàm Service");
		logger.info("debug enabled: {}", logger.isDebugEnabled());
	    logger.trace("trace");
	    logger.debug("debug");
	    logger.info("info");
	    logger.warn("warn");
	    logger.error("error");
	}
	

}
