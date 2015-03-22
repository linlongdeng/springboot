package boot;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.Environment;

@Component
public class MyBean {

    @Value("${name}")
    private String name;
    
    @Value("${my.secret}")
    private String secret; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}


}