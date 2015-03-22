package boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemospringbootApplication.class)
@WebAppConfiguration
public class DemospringbootApplicationTests {

	
	
	@Test
	public void contextLoads() {
		
		Logger logger = LoggerFactory.getLogger(getClass());
	    logger.debug("Hello world.");
	}

}
