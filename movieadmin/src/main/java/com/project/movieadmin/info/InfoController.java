package com.project.movieadmin.info;

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
public class InfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/i_selectOne.do", method = RequestMethod.GET)
	public String i_selectOne(int cpage, int pageBlock, Model model) {
		
		
		return "info/selectOne";
	}
	
	@RequestMapping(value = "/i_selectAll.do", method = RequestMethod.GET)
	public String i_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		
		
		return "info/selectAll";
	}
	
	@RequestMapping(value = "/i_searchList.do", method = RequestMethod.GET)
	public String i_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		
		
		return "info/selectAll";
	}
	
	@RequestMapping(value = "/i_increaseRecommends.do", method = RequestMethod.GET)
	public String i_increaseRecommends(int cpage, int pageBlock, Model model) {
		
		
		return "info/increaseRecommends";
	}
	

	
	
}