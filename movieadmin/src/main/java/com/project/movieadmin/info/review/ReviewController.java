package com.project.movieadmin.info.review;

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

import com.project.movieadmin.info.InfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@Autowired
	private ServletContext sContext;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private InfoService comService;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/rv_insert.do", method = RequestMethod.GET)
	public String rv_insert(Model model) {
		
		log.info("Welcome rv_insert.do....");
		String nickname = (String) session.getAttribute("user_id");
		model.addAttribute(nickname);	
		return "rv_insert";
	}
	
	@RequestMapping(value = "/rv_insertOK.do", method = RequestMethod.GET)
	public String rv_insertOK(ReviewVO vo) {
		
		log.info("Welcome rv_insertOK.do...");
		log.info(vo.toString());

		int result = service.rv_insert(vo);
		log.info("result:{}", result);

		return "redirect:rv_selectOne.do?review_num=";
	}
	
	
	
	@RequestMapping(value = "/rv_update.do", method = RequestMethod.GET)
	public String rv_update(Model model) {
		
		log.info("Welcome rv_update.do....");
		String nickname = (String) session.getAttribute("user_id");
		model.addAttribute(nickname);	
		return "rv_update";
	}
	
	@RequestMapping(value = "/rv_updateOK.do", method = RequestMethod.GET)
	public String rv_updateOK(ReviewVO vo) {
		
		log.info("Welcome rv_updateOK.do...");
		log.info(vo.toString());

		int result = service.rv_update(vo);
		log.info("result:{}", result);

		
		return "rv_updateOK";
	}
	
	@RequestMapping(value = "/rv_delete.do", method = RequestMethod.GET)
	public String rv_delete(Model model) {
		
		log.info("Welcome rv_delete.do....");
		String nickname = (String) session.getAttribute("user_id");
		
	
		return "rv_delete";
	}
	
	@RequestMapping(value = "/rv_deleteOK.do", method = RequestMethod.GET)
	public String rv_deleteOK(ReviewVO vo) {
		
		log.info("Welcome rv_deleteOK.do...");
		log.info(vo.toString());

		int result = service.rv_delete(vo);
		log.info("result:{}", result);

	
		return "rv_deleteOK";
	}
	
	
	@RequestMapping(value = "/rv_selectOne.do", method = RequestMethod.GET)
	public String rv_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "Review/rv_selectOne";
	}
	@RequestMapping(value = "/rv_selectAll.do", method = RequestMethod.GET)
	public String rv_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome selectAll!");
		
		model.addAttribute("totalPageCount");

			
	
		return "Review/rv_selectAll";
	}
	@RequestMapping(value = "rv_searchList.do", method = RequestMethod.GET)
	public String rv_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		
		//test

		return "Review/rv_selectAll";
	}
	
	@RequestMapping(value = "/rv_increaseGood.do", method = RequestMethod.GET)
	public String rv_increaseGood(ReviewVO vo) {
		
	
		return "rv_increaseGood";
	}
	
	@RequestMapping(value = "/rv_increaseGoodOK.do", method = RequestMethod.GET)
	public String rv_increaseGoodOK(ReviewVO vo) {
		
	
		return "rv_increaseGoodOK";
	}
	
	@RequestMapping(value = "/rv_increaseReport.do", method = RequestMethod.GET)
	public String rv_increaseReport(ReviewVO vo) {
		
	
		return "rv_increaseReport";
	}
	
	@RequestMapping(value = "/rv_increaseReportOK.do", method = RequestMethod.GET)
	public String rv_increaseReportOK(ReviewVO vo) {
		
	
		return "rv_increaseReportOK";
	}
	
	
	
	
}