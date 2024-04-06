package com.project.movieadmin.board.comments;

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
public class CommentsController {

	@RequestMapping(value = "/c_insert.do", method = RequestMethod.GET)
	public String c_insert() {
		log.info("Welcome c_insert.do...");
		
		return "board/comments/insert";
	}

	@RequestMapping(value = "/c_insertOK.do", method = RequestMethod.GET)
	public String c_insertOK(CommentsVO vo) {
		log.info("Welcome c_insertOK.do...");
		
		return "board/comments/insertOK";
	}
	@RequestMapping(value = "/c_selectAll.do", method = RequestMethod.GET)
	public String c_selectAll(@RequestParam(
			defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome c_selectAll.do...");
		
		return "board/comments/selectAll";
	}
	
	@RequestMapping(value = "/c_update.do", method = RequestMethod.GET)
	public String c_update(CommentsVO vo, Model model) {
		log.info("Welcome c_update.do...");
		
		return "board/comments/update";
	}
	
	@RequestMapping(value = "/c_updateOK.do", method = RequestMethod.GET)
	public String c_updateOK(CommentsVO vo) {
		log.info("Welcome c_updateOK.do...");
		
		return "board/comments/updateOK";
	}
	
	@RequestMapping(value = "/c_delete.do", method = RequestMethod.GET)
	public String c_delete() {
		log.info("Welcome c_delete.do...");
		
		return "board/comments/delete";
	}
	
	@RequestMapping(value = "/c_deleteOK.do", method = RequestMethod.GET)
	public String c_deleteOK(CommentsVO vo) {
		log.info("Welcome c_deleteOK.do...");
		
		return "board/comments/deleteOK";
	}
	
}