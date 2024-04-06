package com.project.movieadmin.news.comments;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.movieadmin.faq.FaqVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NCommentsController {
	
	private static final Logger logger = LoggerFactory.getLogger(NCommentsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/nc_insert.do", method = RequestMethod.GET)
	public String nc_insert(FaqVO vo) {
		logger.info("Welcome nc_insert!");

		return "NComments/insert";
	}
	@RequestMapping(value = "/nc_insertOK.do", method = RequestMethod.GET)
	public String nc_insertOK(FaqVO vo) {
		logger.info("Welcome nc_insertOK!");

		return "NComments/insertOK";
	}
	@RequestMapping(value = "/nc_selectAll.do", method = RequestMethod.GET)
	public String nc_selectAll(FaqVO vo) {
		logger.info("Welcome nc_selectAll!");

		return "NComments/selectAll";
	}
	@RequestMapping(value = "/nc_update.do", method = RequestMethod.GET)
	public String nc_update(FaqVO vo) {
		logger.info("Welcome nc_update!");

		return "NComments/update";
	}
	@RequestMapping(value = "/nc_updateOK.do", method = RequestMethod.GET)
	public String nc_updateOK(FaqVO vo) {
		logger.info("Welcome nc_updateOK!");

		return "NComments/updateOK";
	}
	@RequestMapping(value = "/nc_delete.do", method = RequestMethod.GET)
	public String nc_delete(FaqVO vo) {
		logger.info("Welcome nc_delete!");

		return "NComments/delete";
	}
	@RequestMapping(value = "/nc_deleteOK.do", method = RequestMethod.GET)
	public String nc_deleteOK(FaqVO vo) {
		logger.info("Welcome nc_deleteOK!");

		return "NComments/deleteOK";
	}
}
