package com.project.movieadmin.board.comments;

import java.util.List;

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
public class CommentsController {

	@Autowired
	private CommentsService service;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	@RequestMapping(value = "/c_insert.do", method = RequestMethod.GET)
	public String c_insert(Model model) {
		log.info("Welcome c_insert.do...");
		String nickname = (String) session.getAttribute("user_id");
		model.addAttribute(nickname);
		
		return "board/comments/insert";
	}

	@RequestMapping(value = "/c_insertOK.do", method = RequestMethod.POST)
	public String c_insertOK(CommentsVO vo) {
		log.info("Welcome c_insertOK.do...");

		int result = service.c_insert(vo);

		if (result == 1) {
			return "redirect:c_selectAll.do";
		} else {
			return "redirect:c_insert.do";
		}
	}

	@RequestMapping(value = "/c_selectAll.do", method = RequestMethod.GET)
	public String c_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome c_selectAll.do...");
		
		List<CommentsVO> vos = service.c_selectAll(cpage, pageBlock);

		model.addAttribute("vos", vos);

		int total_rows = service.c_getTotalRows();

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}

		model.addAttribute("totalPageCount", totalPageCount);

		return "board/comments/selectAll";
	}

	@RequestMapping(value = "/c_update.do", method = RequestMethod.GET)
	public String c_update(CommentsVO vo, Model model) {
		log.info("Welcome c_update.do...");

		return "board/comments/update";
	}

	@RequestMapping(value = "/c_updateOK.do", method = RequestMethod.POST)
	public String c_updateOK(CommentsVO vo) {
		log.info("Welcome c_updateOK.do...");

		int result = service.c_update(vo);

		if (result == 1) {
			return "redirect:c_selectAll.do";
		} else {
			return "redirect:c_update.do";
		}
	}

	@RequestMapping(value = "/c_delete.do", method = RequestMethod.GET)
	public String c_delete() {
		log.info("Welcome c_delete.do...");

		return "board/comments/delete";
	}

	@RequestMapping(value = "/c_deleteOK.do", method = RequestMethod.POST)
	public String c_deleteOK(CommentsVO vo) {
		log.info("Welcome c_deleteOK.do...");

		int result = service.c_delete(vo);

		if (result == 1) {
			return "redirect:c_selectAll.do";
		} else {
			return "redirect:c_delete.do";
		}
	}

}