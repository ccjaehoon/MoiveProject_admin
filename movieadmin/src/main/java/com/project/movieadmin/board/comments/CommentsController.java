package com.project.movieadmin.board.comments;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class CommentsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	

	@RequestMapping(value = "c_insert", method = RequestMethod.GET)
	public String c_insert() {
		logger.info("Welcome c_insert.do...");
		
		return "comments/insert";
	}

	@RequestMapping(value = "c_insertOK", method = RequestMethod.GET)
	public String c_insertOK(CommentsVO vo) {
		logger.info("Welcome c_insertOK.do...");
		
		return "comments/insertOK";
	}
	@RequestMapping(value = "c_selectAll", method = RequestMethod.GET)
	public String c_selectAll(@RequestParam(
			defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome c_selectAll.do...");
		
		return "comments/selectAll";
	}
	
	@RequestMapping(value = "c_update", method = RequestMethod.GET)
	public String c_update(CommentsVO vo, Model model) {
		logger.info("Welcome c_update.do...");
		
		return "comments/update";
	}
	
	@RequestMapping(value = "c_updateOK", method = RequestMethod.GET)
	public String c_updateOK(CommentsVO vo) {
		logger.info("Welcome c_updateOK.do...");
		
		return "comments/updateOK";
	}
	
	@RequestMapping(value = "c_delete", method = RequestMethod.GET)
	public String c_delete() {
		logger.info("Welcome c_delete.do...");
		
		return "comments/delete";
	}
	
	@RequestMapping(value = "c_deleteOK", method = RequestMethod.GET)
	public String c_deleteOK(CommentsVO vo) {
		logger.info("Welcome c_deleteOK.do...");
		
		return "comments/deleteOK";
	}
	
	@RequestMapping(value = "c_increaseGood", method = RequestMethod.GET)
	public String c_increaseGood(CommentsVO vo) {
		logger.info("Welcome c_increaseGood.do...");
		
		return "commnets/increaseGood";
	}
	
}