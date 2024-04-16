package com.project.movieadmin.news.comments;

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
public class NCommentsRestController {

	private static final Logger logger = LoggerFactory.getLogger(NCommentsRestController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private NCommentsService service;
	
	@ResponseBody
	@RequestMapping(value = "/nc_increaseGood.do", method = RequestMethod.GET)
	public Map<String , Object> nc_increaseGood(NCommentsVO vo) {
		log.info("increaseGood.do...{}", vo);
		Map<String , Object> map = new HashMap<String, Object>();
		int goodCheck = service.nc_goodCheck(vo);
		if(goodCheck == 0) {
			int increaseGood = service.nc_increaseGood(vo);
			log.info("increaseGood:{}",increaseGood);
			
			int goodSave = service.nc_goodSave(vo);
			log.info("result:{}",goodSave);
		}

		int good = service.nc_selectGood(vo).getGood();
		log.info(service.nc_selectGood(vo).getGood()+"");
		map.put("good", good);
		return map;
	}



}
