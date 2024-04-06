package com.project.movieadmin.announcement;

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
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/a_insert.do", method = RequestMethod.GET)
	public String u_insert() {
		

		return "announcement/insert";
	}
	
	@RequestMapping(value = "/a_insertOK.do", method = RequestMethod.GET)
	public String a_insertOK(AnnouncementVO vo) {
		

		int result = service.a_insert(vo);
	
		if (result == 1) {
			return "redirect:a_selectAll.do";// 메인 홈페이지 로 가는
		} else {
			return "redirect:a_insert.do";
		}
	}
	
	@RequestMapping(value = "/a_update.do", method = RequestMethod.GET)
	public String a_update(AnnouncementVO vo, Model model) {
	

		return "announcement/update";
	}
	@RequestMapping(value = "/a_updateOK.do", method = RequestMethod.GET)
	public String a_updateOK(AnnouncementVO vo, Model model) {
		

		int result = service.a_update(vo);
		
		if (result == 1) {
			return "redirect:u_selectAll.do"; // 마이 페이지
		} else {
			return "redirect:u_insert.do";
		}
	}
	@RequestMapping(value = "/a_delete.do", method = RequestMethod.GET)
	public String a_delete() {
		

		return "announcement/delete";
	}
	@RequestMapping(value = "/a_deleteOK.do", method = RequestMethod.GET)
	public String a_deleteOK(AnnouncementVO vo) {
		

		int result = service.a_delete(vo);
		
		if (result == 1) {
			return "redirect:a_selectAll.do"; // 메인페이지로
		} else {
			return "redirect:a_insert.do";
		}
	}
	
	@RequestMapping(value = "/a_selectOne.do", method = RequestMethod.GET)
	public String a_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "announcement/selectOne";
	}
	@RequestMapping(value = "/a_selectAll.do", method = RequestMethod.GET)
	public String a_selectAll(int cpage, int pageBlock, Model model) {
		
	
		return "announcement/selectAll";
	}
	@RequestMapping(value = "a_searchList.do", method = RequestMethod.GET)
	public String a_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		


		return "announcement/selectAll";
	}
	
}
