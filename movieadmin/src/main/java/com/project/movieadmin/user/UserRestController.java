package com.project.movieadmin.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/json_idCheck.do", method = RequestMethod.GET)
	public Map<String , String> json_idCheck(UserVO vo) {
	
		UserVO vo2 = service.idCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	@RequestMapping(value = "/json_nicknameCheck.do", method = RequestMethod.GET)
	public Map<String , String> json_nicknameCheck(UserVO vo) {
		
		UserVO vo2 = service.idCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	@RequestMapping(value = "/json_emailCheck.do", method = RequestMethod.GET)
	public Map<String , String> json_emailCheck(UserVO vo) {
	

		UserVO vo2 = service.idCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	
	
	
}
