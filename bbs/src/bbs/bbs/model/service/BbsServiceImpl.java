package bbs.bbs.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.bbs.model.dao.BbsDao;

@Service("bbsService")
public class BbsServiceImpl implements BbsService{
	
	@Autowired
	private BbsDao bbsdao;
	
	@Override
	public int loginProcess(String id,String pw) {
		return bbsdao.getUsers(id, pw);
	}
}
