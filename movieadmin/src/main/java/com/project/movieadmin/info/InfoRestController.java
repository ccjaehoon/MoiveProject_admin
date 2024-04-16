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
		
		
		String curPage = request.getParameter("curPage")==null?"1":request.getParameter("curPage");					//�쁽�옱�럹�씠吏�
		String itemPerPage = request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");		//寃곌낵row�닔
		String movieNm = request.getParameter("movieNm")==null?"":request.getParameter("movieNm");						//�쁺�솕紐�
		String directorNm = request.getParameter("directorNm")==null?"":request.getParameter("directorNm");				//媛먮룆紐�
		String openStartDt = request.getParameter("openStartDt")==null?"":request.getParameter("openStartDt");			//媛쒕큺�뿰�룄 �떆�옉議곌굔 ( YYYY )
		String openEndDt = request.getParameter("openEndDt")==null?"":request.getParameter("openEndDt");				//媛쒕큺�뿰�룄 �걹議곌굔 ( YYYY )	
		String prdtStartYear = request.getParameter("prdtStartYear")==null?"":request.getParameter("prdtStartYear");	//�젣�옉�뿰�룄 �떆�옉議곌굔 ( YYYY )
		String prdtEndYear = request.getParameter("prdtEndYear")==null?"":request.getParameter("prdtEndYear");			//�젣�옉�뿰�룄 �걹議곌굔    ( YYYY )
		String repNationCd = request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");			//���몴援��쟻肄붾뱶 (怨듯넻肄붾뱶�꽌鍮꾩뒪�뿉�꽌 '2204'濡� 議고쉶�맂 援�媛�肄붾뱶)
		String[] movieTypeCdArr = request.getParameterValues("movieTypeCdArr")==null? null:request.getParameterValues("movieTypeCdArr");	//�쁺�솕�삎�깭肄붾뱶 諛곗뿴 (怨듯넻肄붾뱶�꽌鍮꾩뒪�뿉�꽌 '2201'濡� 議고쉶�맂 �쁺�솕�삎�깭肄붾뱶)
		
		// 諛쒓툒�궎
		String key = "f1c8cf77dd2d86fde938f2770265ac97";
		
	    KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

		// �쁺�솕肄붾뱶議고쉶 �꽌鍮꾩뒪 �샇異� (boolean isJson, String curPage, String itemPerPage,String directorNm, String movieCd, String movieNm, String openStartDt,String openEndDt, String ordering, String prdtEndYear, String prdtStartYear, String repNationCd, String[] movieTypeCdArr)
	    String movieCdResponse = service.getMovieList(true, curPage, itemPerPage, movieNm, directorNm, openStartDt, openEndDt, prdtStartYear, prdtEndYear, repNationCd, movieTypeCdArr);
		
	    logger.info("movieCdResponse:{}",movieCdResponse);
		
		return movieCdResponse;
	}
	

	
	
}