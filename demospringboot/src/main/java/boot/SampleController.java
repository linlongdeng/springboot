package boot;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MyBean mybean;
	
	@Autowired
	private Config config;
	
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private MyJdbcBean myjdbcBean;
	

    @RequestMapping("/")
    @ResponseBody
    String home() throws InterruptedException {
    	List<Map<String, Object>> list = myjdbcBean.testJdbc();
    	for(Map<String, Object> map : list){
    		Iterator<String> it = map.keySet().iterator();
    		while(it.hasNext()){
    			String key = it.next();
    			System.out.println(map.get(key));
    		}
    	}
        return mybean.getName() + mybean.getSecret();
    }

}