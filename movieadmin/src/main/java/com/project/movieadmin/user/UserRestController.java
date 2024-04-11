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
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	@RequestMapping(value = "/u_idCheck.do", method = RequestMethod.GET)
	public Map<String , String> u_idCheck(UserVO vo) {
	
		UserVO vo2 = service.u_idCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/u_nicknameCheck.do", method = RequestMethod.GET)
	public Map<String , String> u_nicknameCheck(UserVO vo) {
		
		UserVO vo2 = service.u_nicknameCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/u_emailCheck.do", method = RequestMethod.GET)
	public Map<String , String> u_emailCheck(UserVO vo) {
	

		UserVO vo2 = service.u_emailCheck(vo);
		
		Map<String , String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/u_loginCheck.do", method = RequestMethod.POST)
	public Map<String , String> u_loginCheck(UserVO vo) {
	    UserVO vo2 = service.u_loginCheck(vo);
	    
	    Map<String , String> map = new HashMap<String, String>();
	    if (vo2 != null) {
	        map.put("result", "OK");
	    } else {
	        map.put("result", "NOT OK");
	    }

	    return map;
	}
	
    

}
	
	
	

