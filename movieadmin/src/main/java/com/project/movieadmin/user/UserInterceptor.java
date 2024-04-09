package com.project.movieadmin.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HttpSession session;

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle().....");
		
		String sPath = request.getServletPath();
		
		log.info("sPath:{}",sPath);
		log.info("user_id:{}",session.getAttribute("user_id"));
		
		if(sPath.equals("/home.do") 
				|| sPath.equals("")
				|| sPath.equals("")
				|| sPath.equals("")
				|| sPath.equals("")
				|| sPath.equals(""))
				 {
			
			if(session.getAttribute("user_id")==null) {
				response.sendRedirect("login.do");
				return false;
			}
			
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle().....");
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
