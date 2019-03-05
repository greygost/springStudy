package bbs.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import bbs.bbs.model.service.BbsService;
@Controller
public class ViewController {
	
	@Autowired
	private BbsService bbsservice;
	
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
		int r = bbsservice.loginProcess(id, password);
		System.out.println("result : "+r);
		return "";
	}
}
