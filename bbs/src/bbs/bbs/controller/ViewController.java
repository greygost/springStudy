package bbs.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String view = "/list";
		
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
	
	@RequestMapping("/viewer")
	public String viewer(@RequestParam("idx") String idx,Model model,HttpServletRequest request) {
		System.out.println("viewer");
		BbsDTO dto = new BbsDTO();
		dto.setIdx(idx);
		List list  = bbsservice.getContent(dto);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
		model.addAttribute("userId", id);
		model.addAttribute("contents", list);
		dto.setContentIdx(idx);
		List replList = bbsservice.getRepls(dto);
		if(replList != null) {
			for (int i = 0; i < replList.size(); i++) {
				System.out.println(replList.get(i));
			}
		}
		model.addAttribute("repls", replList);
		
		return "/WEB-INF/views/viewer.jsp";
	}
	
	@RequestMapping(value = "/updateProcess",method = RequestMethod.POST)
	@ResponseBody //@ResponseBody�� ������ָ� view�� �������ִ°��� �ƴ϶�, JSON Ȥ�� Object ���·� �����͸� �Ѱ��ش�.
	public String updateProcess(@RequestParam("content") String getContent,@RequestParam("idx") String idx) {
		System.out.println("updateProcess");
		BbsDTO dto = new BbsDTO();
		dto.setContent(getContent);
		dto.setIdx(idx);
		String retval = bbsservice.updateProcess(dto);
		System.out.println(retval);
		String result = "ok";
		if(retval != "1") {
			result = "false";
		}
		return result;
	}
	
	
	@RequestMapping(value = "/replWriteProcess",method=RequestMethod.POST)
	@ResponseBody
	public String replWriteProcess(@RequestParam("contentIdx") String cIdx,@RequestParam("replyContent") String rContent,HttpServletRequest request) {
		bbsdto.setContentIdx(cIdx);
		bbsdto.setReplyContent(rContent);

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
//		���ǿ��� �ҷ��� ���̵� �ۼ��� ���̵� ����
		bbsdto.setLoginId(id);
		String result = "ok";
		bbsservice.repleWriteProcess(bbsdto);
		
		return "/viewer?idx="+cIdx;
	}

}
