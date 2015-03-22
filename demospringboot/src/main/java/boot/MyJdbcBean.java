package boot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyJdbcBean {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>>testJdbc(){
		return jdbcTemplate.queryForList("SELECT * FROM test");
	}

}
