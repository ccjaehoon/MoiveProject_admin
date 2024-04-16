package com.project.movieadmin.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class InfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	/**
	 * 
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	private InfoService service;
	
	@Autowired
	private InfoService comService;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	
	@RequestMapping(value = "/i_selectOne.do", method = RequestMethod.GET)
	public String i_selectOne(int cpage, int pageBlock, Model model) {
		
		log.info("i_selectOne.do");
		InfoVO vo2=service.i_selectOne(vo);
		log.info("vo2:" + vo2);
		model.addAttribute("vo2", vo2);
		
		
		
		String nickname = (String) session.getAttribute("nickname");
		log.info("nickname: {}",nickname);
        
        model.addAttribute("nickname", nickname);
		InfoVO cvo = new InfoVO();
		cvo.setInfo_num(vo.getInfo_num());
		List<InfoVO> cvos = comService.i_selectAll(cvo);
		log.info(cvos.toString());

		model.addAttribute("cvos", cvos);
		
		
		
		return "info/i_selectOne";
	}
	
	@RequestMapping(value = "/i_selectAll.do", method = RequestMethod.GET)
	public String i_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		
		
		
		
		log.info("Welcome i_selectAll.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

		List<InfoVO> vos = service.n_selectAll(cpage, pageBlock);
		for (InfoVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);

		
		int total_rows = service.n_getTotalRows();
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}

		model.addAttribute("totalPageCount", totalPageCount);
		
		
		
		return "info/i_selectAll";
	}
	
	@RequestMapping(value = "/i_searchList.do", method = RequestMethod.GET)
	public String i_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		
		log.info("i_searchList.do");
		try {
			searchWord = UriUtils.decode(searchWord, "UTF-8");
			searchKey = UriUtils.decode(searchKey, "UTF-8");
			List<InfoVO> vos = service.i_searchList(searchKey, searchWord, cpage, pageBlock);
			for (InfoVO x : vos) {
				log.info(x.toString());
			}
			System.out.println("================");

			model.addAttribute("vos", vos);

			
			int total_rows = service.n_getSearchTotalRows(searchKey, searchWord);
			log.info("total_rows:" + total_rows);

			int totalPageCount = 1;
			if (total_rows / pageBlock == 0) {
				totalPageCount = 1;
			} else if (total_rows % pageBlock == 0) {
				totalPageCount = total_rows / pageBlock;
			} else {
				totalPageCount = total_rows / pageBlock + 1;
			}
			
			model.addAttribute("totalPageCount", totalPageCount);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "info/i_selectAll";
	}
	
	@RequestMapping(value = "/i_increaseRecommends.do", method = RequestMethod.GET)
	public String i_increaseRecommends(int cpage, int pageBlock, Model model) {
		
		log.info("Welcome i_increaseRecommends...");
		log.info(vo.toString());
		
		return "info/i_increaseRecommends";
	}
	
//test
	
	
}