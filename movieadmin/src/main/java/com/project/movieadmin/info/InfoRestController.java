package com.project.movieadmin.info;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InfoRestController {

    @Autowired
    private InfoService service;
    
    @Autowired
	private HttpSession session;

	private static final Logger logger = LoggerFactory.getLogger(InfoRestController.class);
	private Gson gson = new GsonBuilder().create();
	
	
    @ResponseBody
    @RequestMapping(value = "/i_favorite.do", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
    public Map<String , Object> i_favorite(InfoVO vo)  {
        logger.info("Welcome i_favorite....");
		String nickname = (String) session.getAttribute("nickname");
		log.info("nickname :" +nickname);
	    	  
	    vo.setNickname(nickname);
        
        
//        InfoVO vo2=service.i_selectOne(vo);
        log.info("favorite.do...{}", vo);
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