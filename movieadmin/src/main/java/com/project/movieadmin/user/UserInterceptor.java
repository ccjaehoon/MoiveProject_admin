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
		log.info("nickname:{}",session.getAttribute("nickname"));
		
		if(sPath.equals("") 
				|| sPath.equals("/a_update.do")	
				|| sPath.equals("/a_delete.do")		
				|| sPath.equals("/a_insert.do")
				|| sPath.equals("/b_update.do")	
				|| sPath.equals("/b_delete.do")		
				|| sPath.equals("/b_insert.do")
				|| sPath.equals("/f_update.do")	
				|| sPath.equals("/f_delete.do")		
				|| sPath.equals("/f_insert.do")
				|| sPath.equals("/i_update.do")	
				|| sPath.equals("/i_delete.do")		
				|| sPath.equals("/i_insert.do")
				|| sPath.equals("/rv_update.do")	
				|| sPath.equals("/rv_delete.do")		
				|| sPath.equals("/rv_insert.do")
				|| sPath.equals("/n_update.do")	
				|| sPath.equals("/n_delete.do")		
				|| sPath.equals("/n_insert.do")
				|| sPath.equals("/nc_update.do")	
				|| sPath.equals("/nc_delete.do")		
				|| sPath.equals("/nc_insert.do")
				|| sPath.equals("/rp_update.do")	
				|| sPath.equals("/rp_delete.do")		
				|| sPath.equals("/rp_insert.do")
				|| sPath.equals("/s_update.do")	
				|| sPath.equals("/s_delete.do")		
				|| sPath.equals("/s_insert.do")
				|| sPath.equals("/sc_update.do")	
				|| sPath.equals("/sc_delete.do")		
				|| sPath.equals("/sc_insert.do")
				|| sPath.equals("/u_selectAll.do")
				|| sPath.equals("/nc_insertOK.do")
				|| sPath.equals("/c_insertOK.do")
				|| sPath.equals("/sc_insertOK.do")
				|| sPath.equals("/rv_insertOK.do")
				|| sPath.equals("/m_myPage.do")
				|| sPath.equals("/nc_increaseGood.do")
				|| sPath.equals("/nc_deleteOK.do")
				|| sPath.equals("/nc_updateOK.do")
				|| sPath.equals("/rp_insertOK.do")
				)
				 {
			
			if(session.getAttribute("user_id")==null) {
				response.sendRedirect("u_login.do");
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
