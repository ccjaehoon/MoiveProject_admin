package com.project.movieadmin.story.comments;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value = "api/selectCommentList.do", method = RequestMethod.GET)
	public List<SCommentsVO> selectCommentList(SCommentsVO vo) {
		log.info("Welcome api/selectCommentList.do...");
		log.info("vo:{}",vo);
		
		List<SCommentsVO> vos = new ArrayList<SCommentsVO>();
		SCommentsVO vo2 = new SCommentsVO();
		vo2.setStory_comments_num(3);
		vo2.setStory_num(3);
		vo2.setContent("1등댓글2");
		vo2.setNickname("nickname4");
		vo2.setWdate(new Date());
		vos.add(vo2);
		
		return vos;
	}
}
