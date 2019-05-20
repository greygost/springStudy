package bbs.bbs.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = "insert into Board (title,content,wrId) values ('"+bbDto.getTitle()+"','"+bbDto.getContent()+"','"+bbDto.getLoginId()+"')";
		tpl.update(sql);
	}

	@Override
	public List getList() {
		String sql = "SELECT idx,title FROM Board";		
		return tpl.queryForObject(sql, 
			new RowMapper<List>() {
				public List mapRow(ResultSet rs,int rowNum) throws SQLException {
					ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
					ResultSetMetaData md = rs.getMetaData();
					int columns = md.getColumnCount();
	//				1번째 요소를 삽입
			        HashMap<String,Object> row0 = new HashMap<String, Object>(columns);
			        for(int i=1; i<=columns; ++i) {
			        	row0.put(md.getColumnName(i), rs.getObject(i));
			        }
			        list.add(row0);
	//		        첫번째 이후 다른 요소가 있는지 확인후 있다면 계속해서 리스트에 삽입
				    while(rs.next()) {			    				    	
				        HashMap<String,Object> row = new HashMap<String, Object>(columns);
				        for(int i=1; i<=columns; ++i) {
				            row.put(md.getColumnName(i), rs.getObject(i));
				        }
				        list.add(row);
				        
				    }
					return list;
				}
	
			}
	);
	}
	
//	하진희씨 전용
	/*
	@Override
	public List getList(){
		String sql = "SELECT idx,title FROM Board";
		
//		디비 정보 셋팅 예시
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://drrush.iptime.org:2033/gangseo";
	    String dbId = "lty";
	    String dbPw = "2501gost";
//	   디비 정보 셋팅 예시 끝
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	    
        try{       
            Class.forName(driver);
            conn = DriverManager.getConnection(url,dbId,dbPw);           
            pstmt = conn.prepareStatement(sql);  
            rs = pstmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			
//	        요소가 있는지 확인후 있다면 계속해서 리스트에 삽입
	        while(rs.next()) {			    				    	
	        	HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        	for(int i=1; i<=columns; ++i) {
		            row.put(md.getColumnName(i), rs.getObject(i));
		        }	        	         
				list.add(row);			        
	        }	       
		   
        }catch(Exception e){
        	System.out.println("Exception!!! -->"+e);
        }finally{
            if(rs != null){ try{ rs.close(); }catch(SQLException e){} }
            if(pstmt != null){ try{ pstmt.close(); }catch(SQLException e){} }
            if(conn != null){ try{ conn.close(); }catch(SQLException e){} }
            
           
        }
        
        return list;
	}
*/
	
	
	
	
}
