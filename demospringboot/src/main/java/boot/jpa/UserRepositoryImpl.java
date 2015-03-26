package boot.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private AbstractApplicationContext abstractApplicationContext;
	
	

	@Transactional
	public void someCustomMethod(User user) {
		applicationContext.getBean(EntityManagerFactory.class);
		System.out.println("开始打印");
		for(String beanName : applicationContext.getBeanDefinitionNames()){
			System.out.println(beanName);
		}
		System.out.println("结束打印");
		ConfigurableListableBeanFactory beanFactory = abstractApplicationContext.getBeanFactory();
		beanFactory.getBeanDefinitionNames();
		
		entityManager.persist(user);
		System.out.println(user);
	}
}