package boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class TestLog {
	public static void main(String[] args) throws InterruptedException {

		Logger logger = LoggerFactory
				.getLogger("chapters.introduction.HelloWorld1");
		
		for(int i = 0; i < 3000; i++){
			logger.debug("Hello world." + i);
			Thread.sleep(1000);
			
		}
		
		
/*		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    // print logback's internal status
	    StatusPrinter.print(lc);*/
		
		
		

	}
}
