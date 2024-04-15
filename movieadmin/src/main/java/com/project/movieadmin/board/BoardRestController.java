package com.project.movieadmin.board;

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
public class BoardRestController {
	
	@Autowired
	private BoardService service;
	
	@ResponseBody
	@RequestMapping(value = "/b_increaseGood.do", method = RequestMethod.POST)
	public Map<String , Object> b_increaseGood(BoardVO vo) {
		log.info("Welcome b_increaseGood!");
		Map<String , Object> map = new HashMap<String, Object>();
		int goodCheck = service.b_goodCheck(vo);
		if(goodCheck == 0) {
			int increaseGood = service.b_increaseGood(vo);
			log.info("increaseGood:{}",increaseGood);
			
			int goodSave = service.b_goodSave(vo);
			log.info("result:{}",goodSave);
		}

		int good = service.b_selectGood(vo).getGood();
		log.info(service.b_selectGood(vo).getGood()+"");
		map.put("good", good);
		return map;
	}
	
	@RequestMapping(value = "/b_increaseReport.do", method = RequestMethod.GET)
	public String b_increaseReport(BoardVO vo) {
		log.info("Welcome b_increaseReport!");

		return "board/increaseReport";
	}
	
}
