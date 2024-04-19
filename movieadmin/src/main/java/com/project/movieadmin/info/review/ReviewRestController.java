package com.project.movieadmin.info.review;

import java.util.HashMap;
import java.util.Map;

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
public class ReviewRestController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private ReviewService service;
	
	
	@ResponseBody
	@RequestMapping(value = "/rv_increaseGood.do", method = RequestMethod.GET)
	public Map<String , Object> rv_increaseGood(ReviewVO vo) {
		log.info("increaseGood.do...{}", vo);
		Map<String , Object> map = new HashMap<String, Object>();
		int goodCheck = service.rv_goodCheck(vo);
		if(goodCheck == 0) {
			int increaseGood = service.rv_increaseGood(vo);
			log.info("increaseGood:{}",increaseGood);
			
			int goodSave = service.rv_goodSave(vo);
			log.info("result:{}",goodSave);
		}

		int good = service.rv_selectGood(vo).getGood();
		log.info(service.rv_selectGood(vo).getGood()+"");
		map.put("good", good);
		return map;
	}



}
