package com.project.movieadmin.mypage;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class MypageController {
	// 깃오류 점검 주석
//	@Autowired
//	private MypageService service;

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
	
	@RequestMapping(value = "/m_myComments.do", method = RequestMethod.GET)
	public String m_myComments() {
		log.info("Welcome m_myComments!");

		return "mypage/myComments";
	}

	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne() {
		log.info("Welcome m_selectOne!");

		return "mypage/selectOne";
	}
}