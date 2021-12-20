package dinhhieu.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DevideService {
	
	private static final Logger log = LoggerFactory.getLogger(DevideService.class);
	
	public void devide(int a1, int a2) {
		
		try {
			int result = a1 / a2;
			log.info("Thưc hiện phép chia : {}/{}", a1, a2, result);
		} catch (ArithmeticException e) {
			String message = MessageFormat.format("Không thể chia 2 số {0}/{1}", a1,a2);
			log.error(message,e);
		}
		
		
	}

}
