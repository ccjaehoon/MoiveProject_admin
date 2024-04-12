package com.project.movieadmin.mypage;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movieadmin.announcement.AnnouncementService;
import com.project.movieadmin.announcement.AnnouncementVO;
import com.project.movieadmin.board.BoardService;
import com.project.movieadmin.board.BoardVO;
import com.project.movieadmin.news.NewsService;
import com.project.movieadmin.news.NewsVO;
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
	private NewsService news_service;
	
	@Autowired
	private AnnouncementService announcement_service;

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
	
		return "mypage/favorite";
	}
	
	@RequestMapping(value = "/m_myPost.do", method = RequestMethod.GET)
	public String m_myPost(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "20") int pageBlock,UserVO vo, Model model) {
		log.info("Welcome m_myPost.do!");
		String nickname = (String) session.getAttribute("nickname");
		log.info("nickname :" +nickname);
	    	  
	    vo.setNickname(nickname);	
		 List<BoardVO> boards = board_service.b_selectAll_nickname(cpage, pageBlock,vo);
		 List<StoryVO> storys = story_service.s_selectAll_nickname(cpage, pageBlock,vo);
		 List<NewsVO> news = news_service.n_selectAll_nickname(cpage, pageBlock,vo);
		 List<AnnouncementVO> annoucnements = announcement_service.a_selectAll_nickname(cpage, pageBlock, vo);
		 
		 for (NewsVO x : news) {
				log.info(x.toString());
			}
			log.info("================");
		 
		 
		 
		 
		 model.addAttribute("boards", boards);
		 model.addAttribute("storys", storys);
		 model.addAttribute("news", news);
		 model.addAttribute("annoucnements", annoucnements);
		 
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
