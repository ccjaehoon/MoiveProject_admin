package com.project.movieadmin.story.comments;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
public class SCommentsController {
	
	@Autowired
	private SCommentsService service;
	
	@Autowired
	private HttpSession session;

	
	
	@RequestMapping(value = "SComments_insertOK.do", method = RequestMethod.GET)
	public String sc_insertOK(SCommentsVO vo) {
		log.info("Welcome SComments_insertOK...");
		log.info("vo:{}",vo);

		int result = service.sc_insert(vo);
		log.info("result:{}", result);
		if (result == 1) {
			 int storyNum = vo.getStory_num();
	//storyNum이라는 새로운 변수명을 만드는 이유는 SCommentsVO 객체에서 story_num 값을 가져와 사용하기 위해
			return "redirect:s_selectOne.do?story_num=" + storyNum;
		} else {
			return "redirect:sc_insert.do";
		}
	}
	
	@RequestMapping(value = "SComments_updateOK.do", method = RequestMethod.GET)
	public String sc_updateOK(SCommentsVO vo) {
		log.info("Welcome SComments_updateOK...");
		log.info("vo:{}",vo);
		
		int result = service.sc_update(vo);
		log.info("result:{}",result);
		
		return "redirect:SComments_selectAll.do?num="+vo.getStory_comments_num();
	}
	
	@RequestMapping(value = "SComments_deleteOK.do", method = RequestMethod.GET)
	public String sc_deleteOK(SCommentsVO vo) {
		log.info("Welcome SComments_deleteOK...");
		log.info("vo:{}",vo);
		
		int result = service.sc_delete(vo);
		log.info("result:{}",result);
		
		return "redirect:SComments_selectAll.do?num="+vo.getStory_comments_num();
	}
	

	@ResponseBody
	@RequestMapping(value = "api/selectCommentList.do", method = RequestMethod.GET)
	public List<SCommentsVO> selectCommentList(SCommentsVO vo) {
		log.info("Welcome api/selectCommentList.do...");
		log.info("vo:{}",vo);
		
		List<SCommentsVO> vos = service.sc_selectAll(vo);
			
		return vos;
	}
}



