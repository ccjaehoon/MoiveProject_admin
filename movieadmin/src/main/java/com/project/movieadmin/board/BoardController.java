package com.project.movieadmin.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		logger.info("Welcome b_insert.do....");
		
		return "board/insert";
	}

	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.GET)
	public String b_insertOK(BoardVO vo) {
		logger.info("Welcome b_insertOK.do...");
		
		return "board/insertOK";
	}
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(@RequestParam(
			defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome b_selectAll.do...");
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(
			@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock,
			Model model, String searchKey, String searchWord) {
		logger.info("Welcome b_searchList.do...");
		
		return "board/searchList";
	}
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo, Model model) {
		logger.info("Welcome b_insert.do...");
		
		return "board/selectOne";
	}
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		logger.info("Welcome b_update.do...");
		
		return "board/update";
	}
	
	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.GET)
	public String b_updateOK(BoardVO vo) {
		logger.info("Welcome b_updateOK.do...");
		
		return "board/updateOK";
	}
	
	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		logger.info("Welcome b_delete.do...");
		
		return "board/delete";
	}
	
	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.GET)
	public String b_deleteOK(BoardVO vo) {
		logger.info("Welcome b_deleteOK.do...");
		
		return "board/deleteOK";
	}
	
}
