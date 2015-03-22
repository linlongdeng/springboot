package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/jdbc.properties")
public class AppConfig {
	
    @Autowired
    Environment env;
    
    public String getProperties(){
    	String property = env.getProperty("jdbc.user");
    	return property;
    	
    }


}
