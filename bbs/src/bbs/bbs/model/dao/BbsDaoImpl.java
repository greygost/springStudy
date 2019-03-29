package bbs.bbs.model.dao;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bbs.bbs.model.dto.BbsDTO;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	@Autowired
	private JdbcTemplate tpl;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.tpl =  new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getUsers(BbsDTO bbDto) {
		String sql = "select count(*) as cnt from Member where memberId = '"+bbDto.getLoginId()+"' and password = '"+bbDto.getPassword()+"'";
		
		System.out.println(sql);
		return tpl.queryForObject(sql, Integer.class);
		
	}
	
	@Override
	public void insertArticle(BbsDTO bbDto) {
		String sql = "insert into Board ('title','content') values("+bbDto.getTitle()+","+bbDto.getContent()+")";
		tpl.queryForObject(sql, String.class);
	}
	
}
