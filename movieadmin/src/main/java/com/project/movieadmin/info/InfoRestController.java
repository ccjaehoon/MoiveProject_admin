package com.project.movieadmin.info;

import java.util.Arrays;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InfoRestController {
	
	@Autowired
	InfoService service;
	
	
	
	
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(InfoRestController.class);
	private Gson gson = new GsonBuilder().create();// json텍스트를 한줄로 출력
	@ResponseBody
	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
	public String json_test(Locale locale, Model model, HttpServletRequest request) throws OpenAPIFault, Exception {
		logger.info("Welcome json_selectAll....");
		 // 발급키
	    String key = "f1c8cf77dd2d86fde938f2770265ac97";

	    // KOBIS 오픈 API Rest Client를 통해 호출
	    KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

	    // 영화 목록 조회 서비스 호출
	    String movieListResponse = service.getMovieList(true, "1", "100", "", "", "", "", "", "", "", null);
	    logger.info("Movie list response: {}", movieListResponse);
	    logger.info(movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1));
	    
	    String txt_json = movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1);
	    MovieVO[] vo_gson = gson.fromJson(txt_json, MovieVO[].class);
		logger.info(Arrays.asList(vo_gson).toString());
		for (MovieVO movieVO : Arrays.asList(vo_gson)) {
			service.i_insert(movieVO);
		}
		

				
		return movieListResponse;
	}
}