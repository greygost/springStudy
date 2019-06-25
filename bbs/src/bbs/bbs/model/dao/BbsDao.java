package bbs.bbs.model.dao;

import java.util.List;

import bbs.bbs.model.dto.BbsDTO;

public interface BbsDao {
	int getUsers(BbsDTO bbsDto);	
	void insertArticle(BbsDTO bbsDto);	
	List getList();
	List getContents(BbsDTO bbsDto);
}
