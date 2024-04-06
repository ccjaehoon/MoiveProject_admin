package com.project.movieadmin.user;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */

@Slf4j
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/u_insert.do", method = RequestMethod.GET)
	public String u_insert() {
		

		return "user/insert";
	}
	
	@RequestMapping(value = "/u_insertOK.do", method = RequestMethod.GET)
	public String u_insertOK(UserVO vo) {
		

		int result = service.u_insert(vo);
	
		if (result == 1) {
			return "redirect: u_selectAll.do";// 메인 홈페이지 로 가는
		} else {
			return "redirect:u_insert.do";
		}
	}
	
	@RequestMapping(value = "/u_update.do", method = RequestMethod.GET)
	public String u_update(UserVO vo, Model model) {
	

		return "user/update";
	}
	@RequestMapping(value = "/u_updateOK.do", method = RequestMethod.GET)
	public String u_updateOK(UserVO vo, Model model) {
		

		int result = service.u_update(vo);
		
		if (result == 1) {
			return "redirect: uselectAll.do"; // 마이 페이지
		} else {
			return "redirect:uinsert.do";
		}
	}
	@RequestMapping(value = "/u_delete.do", method = RequestMethod.GET)
	public String u_delete() {
		

		return "user/delete";
	}
	@RequestMapping(value = "/u_deleteOK.do", method = RequestMethod.GET)
	public String u_deleteOK(UserVO vo) {
		

		int result = service.u_delete(vo);
		
		if (result == 1) {
			return "redirect:u_selectAll.do"; // 메인페이지로
		} else {
			return "redirect:u_insert.do";
		}
	}
	@RequestMapping(value = "/u_selectOne.do", method = RequestMethod.GET)
	public String u_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "user/selectOne";
	}
	@RequestMapping(value = "/u_selectAll.do", method = RequestMethod.GET)
	public String u_selectAll(int cpage, int pageBlock, Model model) {
		logger.info("Welcome uselectAll!");
	
		return "user/selectAll";
	}
	@RequestMapping(value = "u_searchList.do", method = RequestMethod.GET)
	public String u_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		


		return "user/selectAll";
	}

	@RequestMapping(value = "u_login.do", method = RequestMethod.GET)
	public String u_login() {
		

		return "user/login";
	}
	@RequestMapping(value = "u_logout.do", method = RequestMethod.GET)
	public String u_logout() {
		

		session.removeAttribute("user_id");

		return "redirect:index.do"; // 메인 홈페이지
	}
	
}
