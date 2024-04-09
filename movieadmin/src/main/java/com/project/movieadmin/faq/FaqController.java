package com.project.movieadmin.faq;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
	//깃오류 점검 주석
	@Autowired
	private FaqService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/f_insert.do", method = RequestMethod.GET)
	public String f_insert() {
		log.info("Welcome f_insert!");

		return "faq/insert";
	}
	@RequestMapping(value = "/f_insertOK.do", method = RequestMethod.POST)
	public String f_insertOK(FaqVO vo) {
		log.info("Welcome f_insertOK!");

		log.info("vo:{}", vo);

		int result = service.f_insert(vo);
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
		List<FaqVO> vos = service.f_selectAll(cpage, pageBlock);

        model.addAttribute("vos", vos);


        int total_rows = service.f_getTotalRows();

        int totalPageCount = 1;
        if (total_rows / pageBlock == 0) {
            totalPageCount = 1;
        } else if (total_rows % pageBlock == 0) {
            totalPageCount = total_rows / pageBlock;
        } else {
            totalPageCount = total_rows / pageBlock + 1;
        }

        model.addAttribute("totalPageCount", totalPageCount);

        return "faq/selectAll";
	}
	@RequestMapping(value = "/f_searchList.do", method = RequestMethod.GET)
	public String f_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome f_searchList.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);
		log.info("searchKey : {}, searchWord : {}", searchKey, searchWord);


		List<FaqVO> vos = service.f_searchList(searchKey, searchWord, cpage, pageBlock);
		for (FaqVO x : vos) {
			log.info(x.toString());
		}
		System.out.println("================");

		model.addAttribute("vos", vos);

		// 키워드검색 게시글수는 몇개?
		int total_rows = service.f_getSearchTotalRows(searchKey, searchWord);
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "faq/selectAll";
	}
	@RequestMapping(value = "/f_selectOne.do", method = RequestMethod.GET)
	public String f_selectOne(FaqVO vo, Model model) {
		log.info("Welcome f_selectOne.do....");

		log.info("vo : {}", vo);

		FaqVO vo2 = service.f_selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		model.addAttribute("vo2", vo2);

		return "faq/selectOne";
	}
	@RequestMapping(value = "/f_update.do", method = RequestMethod.GET)
	public String f_update(FaqVO vo, Model model) {
		log.info("Welcome f_update!");

		return "faq/update";
	}
	@RequestMapping(value = "/f_updateOK.do", method = RequestMethod.POST)
	public String f_updateOK(FaqVO vo) {
		log.info("Welcome b_updateOK...");
		log.info("vo:{}", vo);

		int result = service.f_update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:f_selectOne.do?faq_num=" + vo.getFaq_num();
		} else {
			return "redirect:f_update.do?faq_num=" + vo.getFaq_num();
		}

	}
	@RequestMapping(value = "/f_delete.do", method = RequestMethod.GET)
	public String f_delete() {
		log.info("Welcome f_delete!");

		return "faq/delete";
	}
	@RequestMapping(value = "/f_deleteOK.do", method = RequestMethod.POST)
	public String f_deleteOK(FaqVO vo) {
		log.info("Welcome b_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.f_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:f_selectAll.do";
		} else {
			return "redirect:f_delete.do?num=" + vo.getFaq_num();
		}
	}
	
}
