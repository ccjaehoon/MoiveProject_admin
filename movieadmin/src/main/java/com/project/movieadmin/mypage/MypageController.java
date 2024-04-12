package com.project.movieadmin.mypage;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.movieadmin.news.comments.NCommentsVO;
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
	public String m_favorite() {
		log.info("Welcome m_favorite!");

		return "mypage/favorite";
	}
	
	@RequestMapping(value = "/m_myPost.do", method = RequestMethod.GET)
	public String m_myPost() {
		log.info("Welcome m_myPost!");

		return "mypage/myPost";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(UserVO vo, Model model, HttpSession session) {
	   
		UserVO user_id = (UserVO) session.getAttribute("user_id");

	   
	    if (user_id == null) {
	        return "redirect:/login";
	    }

	    
	  
	    vo.setUser_num(user_id.getUser_num());
	    UserVO vo2 = user_service.u_selectOne(vo);
	    model.addAttribute("vo2", vo2); 

	    return "mypage/selectOne";
	}
}
