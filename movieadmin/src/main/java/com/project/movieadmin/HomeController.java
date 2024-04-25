package com.project.movieadmin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.movieadmin.board.BoardService;
import com.project.movieadmin.board.BoardVO;
import com.project.movieadmin.info.InfoService;
import com.project.movieadmin.info.InfoVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private BoardService bService;
	
	@Autowired
	private InfoService iService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "home.do" }, method = RequestMethod.GET)
	public String home(BoardVO vo, Model model) {
		List<BoardVO> bvos = bService.b_selectAll();
		List<InfoVO> ivos = iService.i_selectAll();
		model.addAttribute("bvos", bvos);
		model.addAttribute("ivos", ivos);
		return "home";
	}
	@RequestMapping(value = "/about_us.do", method = RequestMethod.GET)
	public String about(BoardVO vo, Model model) {
		log.info("/about_us.do...");
		return "about_us";
	}
}
