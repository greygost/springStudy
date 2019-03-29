package bbs.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.bbs.model.dto.BbsDTO;
import bbs.bbs.model.service.BbsService;


@Controller
public class ViewController {
	
	@Autowired
	private BbsService bbsservice;
	@Autowired
	private BbsDTO bbsdto;
	
	
	@RequestMapping("/login")
	public String login() {	
		System.out.println("login");
		return "/WEB-INF/views/login.jsp";
	}
	

	@RequestMapping(value = "/loginProcess",method=RequestMethod.POST)
	public String loginProcess(@RequestParam("id") String id,@RequestParam("password") String password) {
		
//		System.out.println("process");
//		boolean id_result = false;
//		boolean pass_result = false;
//		if(id.equals("dev")) {
//			id_result = true;
//		}
//		if(password.equals("a12345")) {
//			pass_result = true;
//		}
//		
//		if(id_result == true && pass_result == true) {
//			return "/WEB-INF/views/loginSuccess.jsp";			
//		}else {
//			return "/WEB-INF/views/loginFail.jsp";	
//		}
//		실제로 서비스와 DAO를 구현하여 로그인을 실행시켜 보자
		
		bbsdto.setLoginId(id);
		bbsdto.setPassword(password);
		int r = bbsservice.loginProcess(bbsdto);
		System.out.println("result : "+r);
		String view = "/WEB-INF/views/loginSuccess.jsp";	;
		if(r == 0) {
			view = "/WEB-INF/views/loginFail.jsp";
		}
		return view;
	}
	
	@RequestMapping("/write")
	public String write() {	
		System.out.println("write");
		return "/WEB-INF/views/write.jsp";
	}
	
	@RequestMapping(value = "/writeProcess",method=RequestMethod.POST)
	public void writeProcess(@RequestParam("id") String id,@RequestParam("password") String password) {
		
	}
}
