package bbs.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String loginProcess(@RequestParam("id") String id,@RequestParam("password") String password,HttpServletRequest request) {		
		bbsdto.setLoginId(id);
		bbsdto.setPassword(password);
		int r = bbsservice.loginProcess(bbsdto);
		System.out.println("result : "+r);
		String view = "/WEB-INF/views/loginSuccess.jsp";
		
//		�α��� ���� �ϸ� ���� �������� �����ϸ� �ش� �α��������� ���̵� ���ǿ� �����Ѵ�.
		if(r == 0) {
			view = "/WEB-INF/views/loginFail.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
		}
		return view;
	}
	
	@RequestMapping("/write")
	public String write() {	
		System.out.println("write");
		return "/WEB-INF/views/write.jsp";
	}
	
	@RequestMapping(value = "/writeProcess",method=RequestMethod.POST)
	public String writeProcess(@RequestParam("title") String getTitle,@RequestParam("content") String getContent,HttpServletRequest request) {
		bbsdto.setTitle(getTitle);
		bbsdto.setContent(getContent);
//		�α������μ������� ������ �α��� ���̵� �ҷ��´�.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
//		���ǿ��� �ҷ��� ���̵� �ۼ��� ���̵� ����
		bbsdto.setLoginId(id);
		bbsservice.writeProcess(bbsdto);
		
		return "/write";
	}
	
	@RequestMapping("/list")
	public String list(Model model ) {
		System.out.println("list");
		List list = bbsservice.getList();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		model.addAttribute("titleList",list);
		return "/WEB-INF/views/list.jsp";
	}
}
