package com.project.movieadmin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class BoardRestController {
	
	@RequestMapping(value = "/b_increaseGood.do", method = RequestMethod.GET)
	public String b_increaseGood(BoardVO vo) {
		log.info("Welcome b_increaseGood!");

		return "board/increaseGood";
	}
	
	@RequestMapping(value = "/b_increaseReport.do", method = RequestMethod.GET)
	public String b_increaseReport(BoardVO vo) {
		log.info("Welcome b_increaseReport!");

		return "board/increaseReport";
	}
	
}
