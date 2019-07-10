package bbs.bbs.model.service;

import java.util.List;

import bbs.bbs.model.dto.BbsDTO;

public interface BbsService {
	int loginProcess(BbsDTO bbsdto);
	void writeProcess(BbsDTO bbsdto);
	List getList();
	List getContent(BbsDTO bbsdto);
	String updateProcess(BbsDTO bbsdto);
	
	void repleWriteProcess(BbsDTO bbsdto);
	
	List getRepls(BbsDTO bbsdto);
}
