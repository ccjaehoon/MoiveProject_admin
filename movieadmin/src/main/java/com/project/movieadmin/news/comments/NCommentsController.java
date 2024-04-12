package com.project.movieadmin.news.comments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class NCommentsController {
	
	@Autowired
	private NCommentsService service;
	
	private static final Logger logger = LoggerFactory.getLogger(NCommentsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/nc_insertOK.do", method = RequestMethod.GET)
	public String nc_insertOK(NCommentsVO vo) {
		log.info("Welcome nc_insertOK...");
		log.info("vo:{}",vo);

		int result = service.nc_insert(vo);
		log.info("result:{}",result);

		return "redirect:n_selectOne.do?news_num="+vo.getNews_num();
	}
	@RequestMapping(value = "/nc_selectAll.do", method = RequestMethod.GET)
	public String nc_selectAll(NCommentsVO vo) {
		logger.info("Welcome nc_selectAll!");
		
		

		return "NComments/selectAll";
	}

	@RequestMapping(value = "/nc_updateOK.do", method = RequestMethod.GET)
	public String nc_updateOK(NCommentsVO vo) {
		log.info("Welcome nc_updateOK...");
		log.info("vo:{}",vo);
		
		int result = service.nc_update(vo);
		log.info("result:{}",result);
		
		return "redirect:n_selectOne.do?news_num="+vo.getNews_num();
	}

	@RequestMapping(value = "/nc_deleteOK.do", method = RequestMethod.GET)
	public String nc_deleteOK(NCommentsVO vo) {
		log.info("Welcome nc_deleteOK...");
		log.info("vo:{}",vo);
		
		int result = service.nc_delete(vo);
		log.info("result:{}",result);
		
		return "redirect:n_selectOne.do?news_num="+vo.getNews_num();
	}

}
