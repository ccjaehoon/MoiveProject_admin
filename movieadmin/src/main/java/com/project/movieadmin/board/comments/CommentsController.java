package com.project.movieadmin.board.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class CommentsController {

	@Autowired
	private CommentsService service;

	@RequestMapping(value = "/c_insertOK.do", method = RequestMethod.GET)
	public String c_insertOK(CommentsVO vo) {
		log.info("Welcome c_insertOK.do...");

		int result = service.c_insert(vo);
		log.info("result:{}", result);

		return "redirect:b_selectOne.do?board_num=" + vo.getBoard_num();
	}

	@RequestMapping(value = "/c_selectAll.do", method = RequestMethod.GET)
	public String c_selectAll(CommentsVO vo) {
		log.info("Welcome c_selectAll.do...");

		return "board/comments/selectAll";
	}

	@RequestMapping(value = "/c_updateOK.do", method = RequestMethod.GET)
	public String c_updateOK(CommentsVO vo) {
		log.info("Welcome c_updateOK.do...");

		int result = service.c_update(vo);
		log.info("result:{}", result);

		return "redirect:b_selectOne.do?board_num=" + vo.getBoard_num();
	}

	@RequestMapping(value = "/c_deleteOK.do", method = RequestMethod.GET)
	public String c_deleteOK(CommentsVO vo) {
		log.info("Welcome c_deleteOK.do...");
		
		int result = service.c_delete(vo);
		log.info("result:{}", result);

		return "redirect:b_selectOne.do?board_num="+vo.getBoard_num();
	}
}