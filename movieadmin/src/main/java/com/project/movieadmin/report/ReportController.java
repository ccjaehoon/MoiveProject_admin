package com.project.movieadmin.report;

import java.util.List;

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
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@RequestMapping(value = "/rp_selectAll.do", method = RequestMethod.GET)
	public String rp_selectAll(Model model) {
		log.info("rp_selectAll.do...");
		
		List<ReportVO> vos = service.rp_selectAll();
		model.addAttribute("vos", vos);
		
		return "report/selectAll";
	}
	@RequestMapping(value = "/rp_selectOne.do", method = RequestMethod.GET)
	public String rp_selectOne(ReportVO vo, Model model) {
		log.info("rp_selectOne.do");
		ReportVO vo2 = service.rp_selectOne(vo);
		model.addAttribute("vo2",vo2);

		return "report/selectOne";
	}

	@RequestMapping(value = "/rp_insertOK.do", method = RequestMethod.POST)
	public String rp_insertOK(ReportVO vo) {
		log.info("rp_insert...");
		
		int result = service.rp_insert(vo);
		if (result == 1) {
			return "redirect:rp_selectAll.do";
		} else {
			return "redirect:rp_insert.do";
		}
	}
	@RequestMapping(value = "/rp_delete.do", method = RequestMethod.GET)
	public String rp_delete() {
		log.info("rp_delete.do");

		return "report/delete";
	}
	@RequestMapping(value = "/rp_deleteOK.do", method = RequestMethod.POST)
	public String rp_deleteOK(ReportVO vo) {
		log.info("Welcome rp_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.rp_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:rp_selectAll.do";
		} else {
			return "redirect:rp_delete.do?report_num=" + vo.getReport_num();
		}

	}
	@RequestMapping(value = "/rp_update.do", method = RequestMethod.GET)
	public String rp_update() {
		log.info("rp_update.do");

		return "report/update";
	}
	@RequestMapping(value = "/rp_updateOK.do", method = RequestMethod.POST)
	public String rp_updateOK(ReportVO vo, Model model) {
		log.info("rp_updateOK.do");
		int result = service.rp_update(vo);
		if (result == 1) {
			return "redirect:rp_selectOne.do?report_num=" +vo.getReport_num();
		} else {
			return "redirect:rp_update.do?report_num=" + vo.getReport_num();
		}
	}
	
}
