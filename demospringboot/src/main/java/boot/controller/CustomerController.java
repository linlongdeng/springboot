package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.jpa.CustomerRepository;
import boot.jpa.User;
import boot.jpa.UserRepositoryCustom;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	@Autowired
private UserRepositoryCustom userRepositoryCustom;
	
	
	@RequestMapping
	@ResponseBody
	  public String showUsers(Model model, Pageable pageable) {
		userRepositoryCustom.someCustomMethod(new User("deng"));
		//userRepositoryCustom.someCustomMethod(new User("deng"));
	    model.addAttribute("customer", customerRepository.findAll(pageable));
	    return "customer";
	  }

}
