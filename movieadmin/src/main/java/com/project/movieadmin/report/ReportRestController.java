package com.project.movieadmin.report;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class ReportRestController {

	private static final Logger logger = LoggerFactory.getLogger(ReportRestController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private ReportService service;
	
	@ResponseBody
	@RequestMapping(value = "/rp_insertOK.do", method = RequestMethod.POST)
	public String rp_insertOK(ReportVO vo) {
		log.info("rp_insert...{}",vo);
		
		int result = service.rp_insert(vo);
		if (result == 1) {
			return "redirect:rp_selectAll.do";
		} else {
			return "redirect:rp_insert.do";
		}
	}

	

}
