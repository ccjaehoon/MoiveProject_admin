package com.project.movieadmin.info;

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
public class InfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
	
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
	
	@RequestMapping(value = "/Info_selectOne.do", method = RequestMethod.GET)
	public String Info_selectOne(int cpage, int pageBlock, Model model) {
		
		
		return "Info/selectOne";
	}
	
	@RequestMapping(value = "/Info_selectAll.do", method = RequestMethod.GET)
	public String Info_selectAll(int cpage, int pageBlock, Model model) {
		
		
		return "Info/selectAll";
	}
	
	@RequestMapping(value = "/Info_searchList.do", method = RequestMethod.GET)
	public String Info_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		
		
		return "Info/selectAll";
	}
	
	@RequestMapping(value = "/Info_increaseRecommends.do", method = RequestMethod.GET)
	public String Info_increaseRecommends(int cpage, int pageBlock, Model model) {
		
		
		return "Info/increaseRecommends";
	}
	

	
	
}