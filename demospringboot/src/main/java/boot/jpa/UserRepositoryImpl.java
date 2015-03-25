package boot.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
	
	
	
	
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager  entityManager ;
	
@Transactional
	  public void someCustomMethod(User user) {
		  entityManager.persist(user);
		  System.out.println(user);
	  }
	}