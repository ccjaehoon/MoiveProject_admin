package com.project.movieadmin.info;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class InfoRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoRestController.class);
	
	@ResponseBody
	@RequestMapping(value = "/json_test.do",
	method = RequestMethod.GET ,
	produces = "text/json; charset=UTF-8")
	
	public String json_test(Locale locale, Model model,HttpServletRequest request) throws OpenAPIFault, Exception {
		logger.info("Welcome json_test....");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//{"today":"+formattedDate+"}
		
		 // 파라메터 설정
		String curPage = request.getParameter("curPage")==null?"1":request.getParameter("curPage");					//현재페이지
		String itemPerPage = request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");		//결과row수
		String movieNm = request.getParameter("movieNm")==null?"":request.getParameter("movieNm");						//영화명
		String directorNm = request.getParameter("directorNm")==null?"":request.getParameter("directorNm");				//감독명
		String openStartDt = request.getParameter("openStartDt")==null?"":request.getParameter("openStartDt");			//개봉연도 시작조건 ( YYYY )
		String openEndDt = request.getParameter("openEndDt")==null?"":request.getParameter("openEndDt");				//개봉연도 끝조건 ( YYYY )	
		String prdtStartYear = request.getParameter("prdtStartYear")==null?"":request.getParameter("prdtStartYear");	//제작연도 시작조건 ( YYYY )
		String prdtEndYear = request.getParameter("prdtEndYear")==null?"":request.getParameter("prdtEndYear");			//제작연도 끝조건    ( YYYY )
		String repNationCd = request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");			//대표국적코드 (공통코드서비스에서 '2204'로 조회된 국가코드)
		String[] movieTypeCdArr = request.getParameterValues("movieTypeCdArr")==null? null:request.getParameterValues("movieTypeCdArr");	//영화형태코드 배열 (공통코드서비스에서 '2201'로 조회된 영화형태코드)
		
		// 발급키
		String key = "f1c8cf77dd2d86fde938f2770265ac97";
		// KOBIS 오픈 API Rest Client를 통해 호출
	    KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

		// 영화코드조회 서비스 호출 (boolean isJson, String curPage, String itemPerPage,String directorNm, String movieCd, String movieNm, String openStartDt,String openEndDt, String ordering, String prdtEndYear, String prdtStartYear, String repNationCd, String[] movieTypeCdArr)
	    String movieCdResponse = service.getMovieList(true, curPage, itemPerPage, movieNm, directorNm, openStartDt, openEndDt, prdtStartYear, prdtEndYear, repNationCd, movieTypeCdArr);
		
	    logger.info("movieCdResponse:{}",movieCdResponse);
		
		return movieCdResponse;
	}
	

	
	
}