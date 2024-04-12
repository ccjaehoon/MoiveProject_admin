package com.project.movieadmin.mypage;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.movieadmin.board.BoardService;
import com.project.movieadmin.board.BoardVO;
import com.project.movieadmin.story.StoryService;
import com.project.movieadmin.story.StoryVO;
import com.project.movieadmin.user.UserService;
import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class MypageController {
	
	
	@Autowired
	private UserService user_service;
	
	@Autowired
	private BoardService board_service;
	
	@Autowired
	private StoryService story_service;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/m_myPage.do", method = RequestMethod.GET)
	public String m_myPage() {
		log.info("Welcome m_myPage!");

		return "mypage/myPage";
	}

	@RequestMapping(value = "/m_favorite.do", method = RequestMethod.GET)
	public String m_favorite(UserVO vo, Model model, HttpSession session) {
		log.info("Welcome m_favorite!");
		String user_id = (String) session.getAttribute("user_id");
		log.info(user_id);
	    	  
	    vo.setUser_id(user_id);
	    UserVO vo2 = user_service.u_selectOne_id(vo);
	    model.addAttribute("vo2", vo2); 
	    log.info("{}", vo2);
		return "mypage/favorite";
	}
	
	@RequestMapping(value = "/m_myPost.do", method = RequestMethod.GET)
	public String m_myPost(Model model) {
		log.info("Welcome m_myPost!");

	
		 
		return "mypage/myPost";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(UserVO vo, Model model, HttpSession session) {

		log.info("Welcome m_selectOne.do!");
		String user_id = (String) session.getAttribute("user_id");
		log.info(user_id);
	    	  
	    vo.setUser_id(user_id);
	    UserVO vo2 = user_service.u_selectOne_id(vo);
	    model.addAttribute("vo2", vo2); 
	    log.info("{}", vo2);


	    return "mypage/selectOne";
	}
}
