package com.project.movieadmin.info;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

//	private static final Logger logger = LoggerFactory.getLogger(InfoRestController.class);
//	private Gson gson = new GsonBuilder().create();// json텍스트를 한줄로 출력
////    @ResponseBody
////    @RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
////    public String json_test(Locale locale, Model model, HttpServletRequest request) throws OpenAPIFault, Exception {
////        logger.info("Welcome json_selectAll....");
////         // 발급키
////        String key = "f1c8cf77dd2d86fde938f2770265ac97";
////
////	    // 영화 목록 조회 서비스 호출
////	    String movieListResponse = service.getMovieList(true, "1", "100", "", "", "", "", "", "", "", null);
////	    logger.info("Movie list response: {}", movieListResponse);
////	    logger.info(movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1));
////	    
////	    String txt_json = movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1);
////	    MovieVO[] vo_gson = gson.fromJson(txt_json, MovieVO[].class);
////		logger.info(Arrays.asList(vo_gson).toString());
////		for (MovieVO movieVO : Arrays.asList(vo_gson)) {
////		//	service.i_insert(movieVO);
////		}
////		
////
////        // KOBIS 오픈 API Rest Client를 통해 호출
////        KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
////
////				
////		return movieListResponse;
////	}
//
//	@ResponseBody
//	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
////	public List<String>  json_selectAll(Locale locale, Model model) throws OpenAPIFault, Exception {
//		public String  json_selectAll(Locale locale, Model model) throws OpenAPIFault, Exception {
//		logger.info("Welcome json_selectAll....");
//
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create(
//						"https://api.themoviedb.org/3/movie/changes?end_date=2024-04-17&page=1&start_date=2024-04-15"))
//				.header("accept", "application/json")
//				.header("Authorization",
//						"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTYxMzgwM2M2Y2E2NmY0N2Y0ZjdjYjMyZWY1OGY1YiIsInN1YiI6IjY2MWYxNzNlNmQ5ZmU4MDE2MzYwMzQ3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pZBphxHkurggb4de8biSCPsZXx1NaC7BrVlaBigLYC8")
//				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
//		MovieVO vo_gson = gson.fromJson(response.body(), MovieVO.class);
//		System.out.println(vo_gson);
//		String txt = "[";
//		for (int i=0;i<vo_gson.results.size();i++) {
//			int id = vo_gson.results.get(i).getId();
//			System.out.println(id);
//			
//			request = HttpRequest.newBuilder()
//				    .uri(URI.create("https://api.themoviedb.org/3/movie/"+id+"?language=ko-KR"))
//				    .header("accept", "application/json")
//				    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTYxMzgwM2M2Y2E2NmY0N2Y0ZjdjYjMyZWY1OGY1YiIsInN1YiI6IjY2MWYxNzNlNmQ5ZmU4MDE2MzYwMzQ3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pZBphxHkurggb4de8biSCPsZXx1NaC7BrVlaBigLYC8")
//				    .method("GET", HttpRequest.BodyPublishers.noBody())
//				    .build();
//				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//				
//				if(i<vo_gson.results.size()-1)txt += response.body()+",";
//				else txt += response.body();
//				
//				//if(i==10)break;
//		}
//		txt += "]";
//		return txt;
//	}
//
////        // 영화 목록 조회 서비스 호출
////        String movieListResponse = service.getMovieList(true, "1", "100", "", "", "", "", "", "", "", null);
////        logger.info("Movie list response: {}", movieListResponse);
////        logger.info(movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1));
////
////        String txt_json = movieListResponse.substring(movieListResponse.indexOf("["),movieListResponse.lastIndexOf("]")+1);
////        MovieVO[] vo_gson = gson.fromJson(txt_json, MovieVO[].class);
////        logger.info(Arrays.asList(vo_gson).toString());
////        for (MovieVO movieVO : Arrays.asList(vo_gson)) {
////            service.insert(movieVO);
////        }
//	
	
}