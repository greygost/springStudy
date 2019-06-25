package bbs.bbs.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.bbs.model.dao.BbsDao;
import bbs.bbs.model.dto.BbsDTO;

@Service("bbsService")
public class BbsServiceImpl implements BbsService{
	
	@Autowired
	private BbsDao bbsdao;
	
	@Override
	public int loginProcess(BbsDTO bbsdto) {
		return bbsdao.getUsers(bbsdto);
	}

	@Override
	public void writeProcess(BbsDTO bbsdto) {
		bbsdao.insertArticle(bbsdto);		
	}

	@Override
	public List getList() {
		return bbsdao.getList();
	}

	@Override
	public List getContent(BbsDTO bbsdto) {
		// TODO Auto-generated method stub
		return bbsdao.getContents(bbsdto);
	}
	
}
