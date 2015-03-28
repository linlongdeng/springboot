package boot.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.jpa.Customer;
import boot.jpa.CustomerRepository;
import boot.jpa.Customer_;
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
	public String showUsers(ModelMap model, Pageable pageable) {
		userRepositoryCustom.someCustomMethod(new User("deng"));
		// userRepositoryCustom.someCustomMethod(new User("deng"));
		model.addAttribute("customer", customerRepository.findAll(pageable));
		return "success";
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public Object showCustomer(@PathVariable("id") Long id) {
		User one = new User("id");
		Customer customer = customerRepository.findOne(id);
		return customer;
	}

	@RequestMapping("/customer/{firstName}")
	@ResponseBody
	public Object findCustomer(@PathVariable("firstName") String firstname) {
		List<Customer> list = customerRepository.findList(firstname);
		return list;

	}

	@RequestMapping("/customer/findspecification")
	@ResponseBody
	public Object findspecification(String firstName) {
		List<Customer> list = customerRepository.findAll(( root,
			query, cb) -> {
					Path<String> path = root.get(Customer_.firstName);
					Path<String> path2 = root.get(Customer_.lastName);
					Predicate predicate = cb.like(path, "林%");
					Predicate predicate2 = cb.like(path2, "龙灯");
					return cb.and(predicate, predicate2);
					//return path.isNotNull();
					//return cb.equal(path, path2);
			//return root.isNotNull();
		});
		return list;

	}

}
