package com.project.movieadmin.info.review;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movie.user.UserDAOimpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/Review_rv_insert.do", method = RequestMethod.GET)
	public String Review_rv_insert(ReviewVO vo) {
		
	
		return "Review_rv_insert";
	}
	
	@RequestMapping(value = "/Review_rv_insertOK.do", method = RequestMethod.GET)
	public String Review_rv_insertOK(ReviewVO vo) {
		
	
		return "Review_rv_insertOK";
	}
	
	@RequestMapping(value = "/Review_rv_update.do", method = RequestMethod.GET)
	public String Review_rv_update(ReviewVO vo) {
		
	
		return "Review_rv_update";
	}
	
	@RequestMapping(value = "/Review_rv_updateOK.do", method = RequestMethod.GET)
	public String Review_rv_updateOK(ReviewVO vo) {
		
	
		return "Review_rv_updateOK";
	}
	
	@RequestMapping(value = "/Review_rv_delete.do", method = RequestMethod.GET)
	public String Review_rv_delete(ReviewVO vo) {
		
	
		return "Review_rv_delete";
	}
	
	@RequestMapping(value = "/Review_rv_deleteOK.do", method = RequestMethod.GET)
	public String Review_rv_deleteOK(ReviewVO vo) {
		
	
		return "Review_rv_deleteOK";
	}
	
	
	@RequestMapping(value = "/Review_rv_selectOne.do", method = RequestMethod.GET)
	public String Review_rv_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "Review/rv_selectOne";
	}
	@RequestMapping(value = "/Review_rv_selectAll.do", method = RequestMethod.GET)
	public String Review_rv_selectAll(int cpage, int pageBlock, Model model) {
		logger.info("Welcome Review_selectAll!");
	
		return "Review/rv_selectAll";
	}
	@RequestMapping(value = "Review_rv_searchList.do", method = RequestMethod.GET)
	public String Review_rv_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		


		return "Review/rv_selectAll";
	}
	
	@RequestMapping(value = "/Review_rv_increaseGood.do", method = RequestMethod.GET)
	public String Review_rv_increaseGood(ReviewVO vo) {
		
	
		return "Review_rv_increaseGood";
	}
	
	@RequestMapping(value = "/Review_rv_increaseGoodOK.do", method = RequestMethod.GET)
	public String Review_rv_increaseGoodOK(ReviewVO vo) {
		
	
		return "Review_rv_increaseGoodOK";
	}
	
	@RequestMapping(value = "/Review_rv_increaseReport.do", method = RequestMethod.GET)
	public String Review_rv_increaseReport(ReviewVO vo) {
		
	
		return "Review_rv_increaseReport";
	}
	
	@RequestMapping(value = "/Review_rv_increaseReportOK.do", method = RequestMethod.GET)
	public String Review_rv_increaseReportOK(ReviewVO vo) {
		
	
		return "Review_rv_increaseReportOK";
	}
	
	
	
	
}