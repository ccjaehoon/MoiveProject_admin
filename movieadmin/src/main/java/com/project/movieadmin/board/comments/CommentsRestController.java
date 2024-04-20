package com.project.movieadmin.board.comments;

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
public class CommentsRestController {
	
	@Autowired
	private CommentsService service;
	
	
	@ResponseBody
	@RequestMapping(value = "/c_increaseGood.do", method = RequestMethod.GET)
	public Map<String, Object> c_increaseGood(CommentsVO vo) {
		log.info("Welcome c_increaseGood.do{}", vo);
		Map<String , Object> map = new HashMap<String, Object>();
		int goodCheck = service.c_goodCheck(vo);
		if(goodCheck == 0) {
			int increaseGood = service.c_increaseGood(vo);
			log.info("increaseGood:{}",increaseGood);
			
			int goodSave = service.c_goodSave(vo);
			log.info("result:{}",goodSave);
		}

		int good = service.c_selectGood(vo).getGood();
		log.info(service.c_selectGood(vo).getGood()+"");
		map.put("good", good);
		return map;
	}	
}
