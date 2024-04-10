package com.project.movieadmin.board;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;
	
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		log.info("Welcome b_insert.do....");
		
		return "board/insert";
	}

	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.GET)
	public String b_insertOK(BoardVO vo) {
		log.info("Welcome b_insertOK.do...");
		
		int result = service.b_insert(vo);
		
		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_insert.do";
		}
	}
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(@RequestParam(
			defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome b_selectAll.do...");
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(
			@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock,
			Model model, String searchKey, String searchWord) {
		log.info("Welcome b_searchList.do...");
		
		return "board/searchList";
	}
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo, Model model) {
		log.info("Welcome b_insert.do...");
		
		return "board/selectOne";
	}
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		log.info("Welcome b_update.do...");
		
		return "board/update";
	}
	
	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.GET)
	public String b_updateOK(BoardVO vo) {
		log.info("Welcome b_updateOK.do...");
		
		int result = service.b_update(vo);
		
		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_update.do";
		}
	}
	
	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("Welcome b_delete.do...");
		
		return "board/delete";
	}
	
	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.GET)
	public String b_deleteOK(BoardVO vo) {
		log.info("Welcome b_deleteOK.do...");
		
		int result = service.b_delete(vo);
		
		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_delete.do";
		}
	}
	
}
