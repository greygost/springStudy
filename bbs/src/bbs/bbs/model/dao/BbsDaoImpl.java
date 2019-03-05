package bbs.bbs.model.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate =  new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getUsers(String id,String pw) {
		String sql = "select count(*) as cnt from Member where memberId = '"+id+"'and password = '"+pw+"'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
	}
	
}
