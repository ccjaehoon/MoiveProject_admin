package com.project.movieadmin.user;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movieadmin.board.BoardService;
import com.project.movieadmin.board.BoardVO;
import com.project.movieadmin.story.StoryService;
import com.project.movieadmin.story.StoryVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */

@Slf4j
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;
	
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

	@RequestMapping(value = "/u_insert.do", method = RequestMethod.GET)
	public String u_insert() {

		return "user/insert";
	}

	@RequestMapping(value = "/u_insertOK.do", method = RequestMethod.POST)
	public String u_insertOK(UserVO vo) {

		int result = service.u_insert(vo);

		if (result == 1) {
			return "redirect:home.do";// 메인 홈페이지 로 가는
		} else {
			return "redirect:u_insert.do";
		}
	}

	@RequestMapping(value = "/u_update.do", method = RequestMethod.GET)
	public String u_update(UserVO vo, Model model) {
		UserVO vo2 = service.u_selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "user/update";
	}

	@RequestMapping(value = "/u_updateOK.do", method = RequestMethod.POST)
	public String u_updateOK(UserVO vo, Model model) {

		int result = service.u_update(vo);

		if (result == 1) {
			return "redirect: m_myPage.do"; // 마이 페이지
		} else {
			return "redirect: u_update.do";
		}
	}

	@RequestMapping(value = "/u_delete.do", method = RequestMethod.GET)
	public String u_delete() {

		return "user/delete";
	}

	@RequestMapping(value = "/u_deleteOK.do", method = RequestMethod.POST)
	public String u_deleteOK(UserVO vo) {

		int result = service.u_delete(vo);

		if (result == 1) {
			return "redirect:u_selectAll.do";
		} else {
			return "redirect:u_delete.do?user_num=" + vo.getUser_num();
		}
	}

	@RequestMapping(value = "/u_selectOne.do", method = RequestMethod.GET)
	public String u_selectOne(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "20") int pageBlock, UserVO vo, Model model) {
		UserVO vo2 = service.u_selectOne(vo);

		model.addAttribute("vo2", vo2);
		 List<BoardVO> boards = board_service.b_selectAll_nickname(cpage, pageBlock,vo2);
		 List<StoryVO> storys = story_service.s_selectAll_nickname(cpage, pageBlock,vo2);
		 model.addAttribute("boards", boards);
		 model.addAttribute("storys", storys);
		 
		return "user/selectOne";
	}

	@RequestMapping(value = "/u_selectAll.do", method = RequestMethod.GET)
	public String u_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "10") int pageBlock, Model model) {

		List<UserVO> vos = service.u_selectAll(cpage, pageBlock);

		model.addAttribute("vos", vos);

		int total_rows = service.u_getTotalRows();

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}

		model.addAttribute("totalPageCount", totalPageCount);

		return "user/selectAll";
	}

	@RequestMapping(value = "u_searchList.do", method = RequestMethod.GET)
	public String u_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "10") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("u_searchList");
		log.info("cpage : " + cpage);
		log.info("pageBlock : " + pageBlock);

		List<UserVO> vos = service.u_searchList(searchKey, searchWord, cpage, pageBlock);

		model.addAttribute("vos", vos);

		int total_rows = service.u_getSearchTotalRows(searchKey, searchWord);
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

		return "user/selectAll";
	}

	@RequestMapping(value = "u_login.do", method = RequestMethod.GET)
	public String u_login() {

		return "user/login";
	}

	@RequestMapping(value = "u_loginOK.do", method = RequestMethod.POST)

	public String u_loginOK(UserVO vo) {
		log.info("Welcome loginOK.do....");

		log.info("vo : {}", vo);

		UserVO vo2 = service.u_login(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		if (vo2 == null) {
			return "redirect:u_login.do?message=0";
		} else {

			session.setAttribute("user_id", vo2.getUser_id());
			session.setAttribute("user_num", vo2.getUser_num());
			session.setAttribute("nickname", vo2.getNickname());
			session.setAttribute("authority", vo2.getAuthority());
			log.info("vo2:" + vo2.getNickname());

			return "redirect:home.do";
		}
	}

	@RequestMapping(value = "u_logout.do", method = RequestMethod.GET)
	public String u_logout() {

		session.removeAttribute("user_num");
		session.removeAttribute("user_id");
		session.removeAttribute("nickname");
		session.removeAttribute("authority");


		return "redirect: home.do";
	}

	@RequestMapping(value = "u_findPwView.do", method = RequestMethod.GET)
	public String u_findPwView() {

		return "user/findPwView";
	}

	@RequestMapping(value = "u_findPw.do", method = RequestMethod.POST)
	public String u_findPw(UserVO vo, Model model) {


		logger.info("userPw" + vo.getUser_id());

		if(service.findPwCheck(vo)==0) {
			log.info("userPWCheck");
			model.addAttribute("msg", "아이디와 이메일을 확인해주세요");

			return "/user/findPwView";
		} 
		else {
	
			UserVO vo2 = service.findPw(vo);
			log.info("vo2 :{}", vo2.toString());
			String msg = "비밀번호는" + vo2.getPassword().toString() +"입니다";
			log.info(msg);
			model.addAttribute("msg", msg);
			
			return"/user/login";
		}
	
	

	}
}
