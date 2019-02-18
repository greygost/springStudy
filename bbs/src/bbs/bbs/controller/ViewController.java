package bbs.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
	
	@RequestMapping("/login")
	public String login() {	
		System.out.println("login");
		return "/WEB-INF/views/login.jsp";
	}
	

	@RequestMapping(value = "/loginProcess",method=RequestMethod.POST)
	public String loginProcess(@RequestParam("id") String id,@RequestParam("password") String password) {
		
		System.out.println("process");
		boolean id_result = false;
		boolean pass_result = false;
		if(id.equals("dev")) {
			id_result = true;
		}
		if(password.equals("a12345")) {
			pass_result = true;
		}
		
		if(id_result == true && pass_result == true) {
			return "/WEB-INF/views/loginSuccess.jsp";			
		}else {
			return "/WEB-INF/views/loginFail.jsp";	
		}
		
	}
}
