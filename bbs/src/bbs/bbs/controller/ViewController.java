package bbs.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("test");
		return "/WEB-INF/views/login.jsp";
	}
}
