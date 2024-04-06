package com.project.movieadmin.board.comments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class CommentsRestController {
	@RequestMapping(value = "/c_increaseGood.do", method = RequestMethod.GET)
	public String c_increaseGood(CommentsVO vo) {
		log.info("Welcome c_increaseGood!");

		return "board/comments/increaseGood";
	}
	
	@RequestMapping(value = "/c_increaseReport.do", method = RequestMethod.GET)
	public String c_increaseReport(CommentsVO vo) {
		log.info("Welcome c_increaseReport!");

		return "board/comments/increaseReport";
	}
	
}
