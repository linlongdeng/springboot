package boot;

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

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(DemospringbootApplication.class);
    	app.addListeners(new ApplicationListener<ApplicationPreparedEvent>(){
    		


			@Override
			public void onApplicationEvent(ApplicationPreparedEvent event) {
				System.out.println("ApplicationPreparedEvent收到");
			}
    		

    		
    	});
    	app.run(args);
       // SpringApplication.run(DemospringbootApplication.class, args);
    }
}
