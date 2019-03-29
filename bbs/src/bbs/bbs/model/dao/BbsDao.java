package bbs.bbs.model.dao;

import bbs.bbs.model.dto.BbsDTO;

public interface BbsDao {
	int getUsers(BbsDTO bbsDto);	
	void insertArticle(BbsDTO bbsDto);
}
