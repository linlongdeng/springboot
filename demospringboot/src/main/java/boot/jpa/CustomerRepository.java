package boot.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends CrudRepository<Customer, Long>,
		JpaSpecificationExecutor<Customer> {

	List<Customer> findByLastName(String lastName);

	@Transactional(timeout = 10)
	<S extends Customer> S save(S entity);

	Page<Customer> findAll(Pageable pageable);

	@Query("select u from Customer u where u.firstName like %?1")
	List<Customer> findList(String firstname);
}