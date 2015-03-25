package boot;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.jpa.Customer;
import boot.jpa.CustomerRepository;

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
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping("/")
	@ResponseBody
	String home() throws InterruptedException {
		Pageable page = new PageRequest(1, 5);
		Page<Customer> pageData = customerRepository.findAll(page);
		List<Customer> list = pageData.getContent();
		System.out.println(list);
		customerRepository.save(new Customer("灯", "林小灯"));

		return "success";
	}

}