package boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

	@Autowired
	private MyBean mybean;
    @RequestMapping("/")
    @ResponseBody
    String home() throws InterruptedException {
    	System.out.println("线程休眠");
    	System.out.println("线程结束休眠");
        return mybean.getName();
    }

}