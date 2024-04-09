package com.project.movieadmin.story;

import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class StoryController {
	
	@Autowired
	private StoryService service;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/s_insert.do", method = RequestMethod.GET)
	public String s_insert() {
		log.info("Welcome story_insert...");

		return "story/insert";
	}
	
	@RequestMapping(value = "/s_insertOK.do", method = RequestMethod.GET)
	public String s_insertOK(StoryVO vo) {
		log.info("Welcome story_insertOK...");
		log.info("vo:{}", vo);
		
		int result = service.s_insert(vo);
		log.info("result:{}", result);
		if (result == 1) {
			return "redirect:s_selectAll.do";
		} else {
			return "redirect:s_insert.do";
		}
	}
	
	@RequestMapping(value = "/s_update.do", method = RequestMethod.GET)
	public String s_update(StoryVO vo, Model model) {
		log.info("Welcome story_update...");
		log.info("vo:{}", vo);
		
//		StoryVO vo2 = service.s_selectRandomList(vo);
//		log.info("vo2:{}", vo2);
//
//		model.addAttribute("vo2", vo2);
		return "story/update";
	}
	@RequestMapping(value = "/s_updateOK.do", method = RequestMethod.GET)
	public String s_updateOK(StoryVO vo) {
		log.info("Welcome story_updateOK...");
		log.info("vo:{}", vo);

		int result = service.s_update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:s_selectRandomList.do?num=" + vo.getStory_num();
		} else {
		return "redirect:s_selectRandomList.do?num=" + vo.getStory_num();
		}
		
	}
	
	@RequestMapping(value = "/s_delete.do", method = RequestMethod.GET)
	public String s_delete() {
		log.info("Welcome story_delete...");

		return "story/delete";
	}
	@RequestMapping(value = "/s_deleteOK.do", method = RequestMethod.GET)
	public String s_deleteOK(StoryVO vo) {
		log.info("Welcome story_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.s_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:s_selectAll.do";
		} else {
			return "redirect:s_delete.do?num=" + vo.getStory_num();
		}

	}
	
	@RequestMapping(value = "/s_selectRandomList.do", method = RequestMethod.GET)
	public String story_selectRandomList(StoryVO vo, Model model) {
		log.info("Welcome s_selectRandomList...");

		return "story/selectRandomList";
	}
	
	@RequestMapping(value = "/s_selectAll.do", method = RequestMethod.GET)
	public String story_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome story_selectAll...");
		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

		List<StoryVO> vos = service.s_selectAll(cpage, pageBlock);
		for (StoryVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);
		
		// 스토리 게시글에 들어있는 게시글
//		int total_rows = service.getTotalRows();
//		log.info("total_rows:" + total_rows);
//
//		int totalPageCount = 1;
//		if (total_rows / pageBlock == 0) {
//			totalPageCount = 1;
//		} else if (total_rows % pageBlock == 0) {
//			totalPageCount = total_rows / pageBlock;
//		} else {
//			totalPageCount = total_rows / pageBlock + 1;
//		}
//		// 페이지 링크 몇개?
//		model.addAttribute("totalPageCount", totalPageCount);
//		

		return "story/selectAll";
	}
	
	
	
	
}