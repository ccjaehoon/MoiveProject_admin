package com.project.movieadmin.info;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
    private InfoService service;

	private static final Logger logger = LoggerFactory.getLogger(InfoRestController.class);
	private Gson gson = new GsonBuilder().create();
	
	
    @ResponseBody
    @RequestMapping(value = "/i_favorite.do", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
    public Map<String , Object> i_favorite(InfoVO vo)  {
        logger.info("Welcome i_favorite....");
         
        log.info("increaseGood.do...{}", vo);
		Map<String , Object> map = new HashMap<String, Object>();
		int favoriteCheck = service.i_favoriteCheck(vo);
		String fav = "";
		if(favoriteCheck == 0) {
			int getFavorite = service.i_getFavorite(vo);
			log.info("i_getFavorite:{}",getFavorite);
			
			int favoriteSave = service.i_favoriteSave(vo);
			log.info("result:{}",favoriteSave);
			 fav = "즐겨찾기 완료";
		}
		
		map.put("fav", fav);
		return map;
    
		

  
				
		
	}


	
	
}