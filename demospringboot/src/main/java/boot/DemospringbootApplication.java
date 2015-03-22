package boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DemospringbootApplication {
	protected static  final Log logger = LogFactory.getLog(DemospringbootApplication.class);
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(DemospringbootApplication.class);
    	app.addListeners(new ApplicationListener<ApplicationPreparedEvent>(){
    		


			@Override
			public void onApplicationEvent(ApplicationPreparedEvent event) {
				logger.debug("ApplicationPreparedEvent收到");
			}
    		

    		
    	});
    	app.run(args);
       // SpringApplication.run(DemospringbootApplication.class, args);
    }
}
