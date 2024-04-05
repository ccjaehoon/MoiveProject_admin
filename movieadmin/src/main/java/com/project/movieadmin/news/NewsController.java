package com.project.movieadmin.news;

import java.util.List;


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
public class NewsController {
	
	@Autowired
	private NewsService service;
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/news_selectAll.do", method = RequestMethod.GET)
	public String n_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("news_selectAll.do...");
		
		List<NewsVO> vos = service.n_selectAll(cpage, pageBlock);
		
		return "news/selectAll";
	}
	@RequestMapping(value = "/news_selectOne.do", method = RequestMethod.GET)
	public String n_selectOne(NewsVO vo, Model model) {
		log.info("news_selectOne.do");
		NewsVO vo2 = service.n_selectOne(vo);

		return "news/selectOne";
	}
	@RequestMapping(value = "/news_searchList.do", method = RequestMethod.GET)
	public String n_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("news_searchList.do");
		List<NewsVO> vos = service.n_searchList(searchKey, searchWord,cpage,pageBlock);

		return "news/selectAll";
	}
	@RequestMapping(value = "/news_insert.do", method = RequestMethod.GET)
	public String n_insert() {
		log.info("news_selectOne.do");

		return "news/insert";
	}
	@RequestMapping(value = "/news_insertOK.do", method = RequestMethod.GET)
	public String n_insertOK(NewsVO vo) {
		log.info("Welcome news_insert...");
		
		int result = service.n_insert(vo);
		if (result == 1) {
			return "redirect:news_selectAll.do";
		} else {
			return "redirect:news_insert.do";
		}
	}
	@RequestMapping(value = "/news_delete.do", method = RequestMethod.GET)
	public String n_delete() {
		log.info("news_delete.do");

		return "news/delete";
	}
	@RequestMapping(value = "/news_deleteOK.do", method = RequestMethod.POST)
	public String n_deleteOK(NewsVO vo) {
		log.info("Welcome news_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.n_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:news_selectAll.do";
		} else {
			return "redirect:news_delete.do?num=" + vo.getNews_num();
		}

	}
	@RequestMapping(value = "/news_update.do", method = RequestMethod.GET)
	public String n_update() {
		log.info("news_update.do");

		return "news/update";
	}
	@RequestMapping(value = "/news_updateOK.do", method = RequestMethod.GET)
	public String n_updateOK(NewsVO vo, Model model) {
		log.info("news_selectOne.do");
		List<NewsVO> vos = service.n_update(vo);

		return "news/selectOne";
	}
	
}
