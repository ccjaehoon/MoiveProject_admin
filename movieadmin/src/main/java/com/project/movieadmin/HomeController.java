package com.project.movieadmin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.movieadmin.announcement.AnnouncementService;
import com.project.movieadmin.announcement.AnnouncementVO;
import com.project.movieadmin.board.BoardService;
import com.project.movieadmin.board.BoardVO;
import com.project.movieadmin.info.InfoService;
import com.project.movieadmin.info.InfoVO;
import com.project.movieadmin.story.StoryService;
import com.project.movieadmin.story.StoryVO;

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
	
	@Autowired
	private AnnouncementService aService;
	
	@Autowired
	private StoryService sService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "home.do" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<BoardVO> bvos = bService.b_selectAll();
		List<InfoVO> ivos = iService.i_selectAll();
		List<AnnouncementVO> avos = aService.a_selectAll();
		List<StoryVO> svos =  sService.s_selectAll(1, 5);
		model.addAttribute("bvos", bvos);
		model.addAttribute("ivos", ivos);
		model.addAttribute("avos", avos);
		model.addAttribute("svos", svos);
		return "home";
	}
	@RequestMapping(value = "/about_us.do", method = RequestMethod.GET)
	public String about() {
		log.info("/about_us.do...");
		return "about_us";
	}
	@RequestMapping(value = "/contact.do", method = RequestMethod.GET)
	public String contact() {
		log.info("/contact.do...");
		return "contact";
	}
}
