package com.project.movieadmin.faq;

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
public class FaqController {
	
	@Autowired
	private FaqService service;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/f_insert.do", method = RequestMethod.GET)
	public String f_insert() {
		log.info("Welcome f_insert!");

		return "faq/insert";
	}
	@RequestMapping(value = "/f_insertOK.do", method = RequestMethod.GET)
	public String f_insertOK(FaqVO vo) {
		log.info("Welcome f_insertOK!");

		log.info("vo:{}", vo);

		int result = service.insert(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:f_selectAll.do";
		} else {
			return "redirect:f_insert.do";
		}
	}
	@RequestMapping(value = "/f_selectAll.do", method = RequestMethod.GET)
	public String f_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome f_selectAll!");

		return "faq/selectAll";
	}
	@RequestMapping(value = "/f_searchList.do", method = RequestMethod.GET)
	public String f_searchList(int cpage, int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome f_searchList!");

		return "faq/searchList";
	}
	@RequestMapping(value = "/f_selectOne.do", method = RequestMethod.GET)
	public String f_selectOne(FaqVO vo, Model model) {
		log.info("Welcome f_selectOne!");

		return "faq/selectOne";
	}
	@RequestMapping(value = "/f_update.do", method = RequestMethod.GET)
	public String f_update(FaqVO vo, Model model) {
		log.info("Welcome f_update!");

		return "faq/update";
	}
	@RequestMapping(value = "/f_updateOK.do", method = RequestMethod.GET)
	public String f_updateOK(FaqVO vo) {
		log.info("Welcome f_updateOK!");

		return "faq/updateOK";
	}
	@RequestMapping(value = "/f_delete.do", method = RequestMethod.GET)
	public String f_delete() {
		log.info("Welcome f_delete!");

		return "faq/delete";
	}
	@RequestMapping(value = "/f_deleteOK.do", method = RequestMethod.GET)
	public String f_deleteOK(FaqVO vo) {
		log.info("Welcome f_deleteOK!");

		return "faq/deleteOK";
	}
	
}
