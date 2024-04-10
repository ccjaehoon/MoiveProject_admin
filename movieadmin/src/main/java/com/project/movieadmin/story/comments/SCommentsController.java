package com.project.movieadmin.story.comments;

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

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class SCommentsController {
	
	@Autowired
	private SCommentsService service;
	
	
	@RequestMapping(value = "SComments_insertOK.do", method = RequestMethod.GET)
	public String sc_insertOK(SCommentsVO vo) {
		log.info("Welcome SComments_insertOK...");
		log.info("vo:{}",vo);

		int result = service.sc_insert(vo);
		log.info("result:{}",result);

		return null;
//		return "redirect:b_selectOne.do?num="+vo.getBnum();
	}
	
	@RequestMapping(value = "SComments_updateOK.do", method = RequestMethod.GET)
	public String sc_updateOK(SCommentsVO vo) {
		log.info("Welcome SComments_updateOK...");
		log.info("vo:{}",vo);
		
		int result = service.sc_update(vo);
		log.info("result:{}",result);
		
		return null;
//		return "redirect:SComments_selectAll.do?num="+vo.getBnum();
	}
	
	@RequestMapping(value = "SComments_deleteOK.do", method = RequestMethod.GET)
	public String sc_deleteOK(SCommentsVO vo) {
		log.info("Welcome SComments_deleteOK...");
		log.info("vo:{}",vo);
		
		int result = service.sc_delete(vo);
		log.info("result:{}",result);
		
		return null;
//		return "redirect:SComments_selectAll.do?num="+vo.getBnum();
	}
}
