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
	private ReviewService service;
	
	@Autowired
	private ServletContext sContext;

	@Autowired
	private HttpSession session;
	


	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	
	@RequestMapping(value = "/rv_insertOK.do", method = RequestMethod.GET)
	public String rv_insertOK(ReviewVO vo) {
		
		log.info("Welcome rv_insertOK.do...");
		log.info(vo.toString());

		int result = service.rv_insert(vo);
		log.info("result:{}", result);

		return "redirect:i_selectOne.do?info_num="+vo.getInfo_num();
		
	}	
	
	
	
	@RequestMapping(value = "/rv_updateOK.do", method = RequestMethod.GET)
	public String rv_updateOK(ReviewVO vo) {
		
		log.info("Welcome rv_updateOK.do...");
		log.info(vo.toString());

		int result = service.rv_update(vo);
		log.info("result:{}", result);

		
		return "redirect:i_selectOne.do?info_num="+vo.getInfo_num();
	}
	

	
	@RequestMapping(value = "/rv_deleteOK.do", method = RequestMethod.GET)
	public String rv_deleteOK(ReviewVO vo) {
		
		log.info("Welcome rv_deleteOK.do...");
		log.info(vo.toString());

		int result = service.rv_delete(vo);
		log.info("result:{}", result);

	
		return "redirect:i_selectOne.do?info_num="+vo.getInfo_num();
	}
	
	
	
	@RequestMapping(value = "/rv_selectAll.do", method = RequestMethod.GET)
	public String rv_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome selectAll!");
		
		model.addAttribute("totalPageCount");

			
	
		return "Review/selectAll";
	}

	
	
	
	
	
	
}