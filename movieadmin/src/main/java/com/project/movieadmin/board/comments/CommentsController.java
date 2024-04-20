package com.project.movieadmin.board.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
<<<<<<< HEAD

	@Autowired
	private CommentsService service;

	@RequestMapping(value = "/c_insertOK.do", method = RequestMethod.GET)
	public String c_insertOK(CommentsVO vo) {
		log.info("Welcome c_insertOK.do...");

		int result = service.c_insert(vo);
		log.info("result:{}", result);

		return "redirect:b_selectOne.do?board_num=" + vo.getBoard_num();
=======
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
	}

<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
