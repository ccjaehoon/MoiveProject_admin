package com.project.movieadmin.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movieadmin.info.review.ReviewVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class StoryController {
	
	@Autowired
	private StoryService service;
	
	@Autowired
	private ServletContext sContext;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/s_insert.do", method = RequestMethod.GET)
	public String s_insert() {
		log.info("Welcome story_insert...");

		return "story/insert";
	}
	
	@RequestMapping(value = "/s_insertOK.do", method = RequestMethod.POST)
	public String s_insertOK(StoryVO vo) throws IOException {
		log.info("Welcome story_insertOK...");
		log.info("vo:{}", vo);
		
		String realPath = sContext.getRealPath("resources/uploadimg");
		log.info(realPath);
		
		String originName = vo.getFile_img().getOriginalFilename();

		log.info("getOriginalFilename:{}", originName);
		if (originName.length() == 0) {
			vo.setSave_img("default.png");// 이미지선택없이 처리할때
		}else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));

			vo.setSave_img(save_name);

			File uploadFile = new File(realPath, save_name);
			vo.getFile_img().transferTo(uploadFile);// 원본 이미지저장

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

		}
		
		
		int result = service.s_insert(vo);
		log.info("result:{}", result);
		if (result == 1) {
			return "redirect:s_selectAll.do";
		} else {
			return "redirect:s_insert.do";
		}
	}
	
	@RequestMapping(value = "/s_update.do", method = RequestMethod.GET)
	public String s_update(StoryVO vo, Model model) {
		log.info("Welcome story_update...");
		log.info("vo:{}", vo);
		
		 List<StoryVO> randomStories = service.s_selectRandomList(vo);
		    if (!randomStories.isEmpty()) {
		        StoryVO vo2 = randomStories.get(0); // 리스트의 첫 번째 요소를 선택
		        log.info("vo2:{}", vo2);
		        model.addAttribute("vo2", vo2);
		 }
		return "story/update";
	}
	@RequestMapping(value = "/s_updateOK.do", method = RequestMethod.POST)
	public String s_updateOK(StoryVO vo) {
		log.info("Welcome story_updateOK...");
		log.info("vo:{}", vo);

		int result = service.s_update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:s_selectRandomList.do?num=" + vo.getStory_num();
		} else {
		return "redirect:s_selectRandomList.do?num=" + vo.getStory_num();
		}
		
	}
	
	@RequestMapping(value = "/s_delete.do", method = RequestMethod.GET)
	public String s_delete() {
		log.info("Welcome story_delete...");

		return "story/delete";
	}
	@RequestMapping(value = "/s_deleteOK.do", method = RequestMethod.GET)
	public String s_deleteOK(StoryVO vo) {
		log.info("Welcome story_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.s_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:s_selectAll.do";
		} else {
			return "redirect:s_delete.do?num=" + vo.getStory_num();
		}

	}
	
	@RequestMapping(value = "/s_selectRandomList.do", method = RequestMethod.GET)
	public String story_selectRandomList(StoryVO vo, Model model) {
		log.info("Welcome s_selectRandomList...");
		
		 // Random 객체 생성
        Random rand = new Random();
        // 예를 들어, 무작위로 선택할 스토리의 ID를 생성 (여기서는 1부터 10까지 가정)
        int storyId = rand.nextInt(10) + 1;
        
        // 무작위로 선택된 스토리 목록을 가져오는 서비스 메소드 호출
        List<StoryVO> randomStories = service.s_selectRandomList(vo);
        
        // 모델에 무작위 스토리 목록 추가
        model.addAttribute("randomStories", randomStories);

		return "story/selectRandomList";
	}
	
	@RequestMapping(value = "/s_selectAll.do", method = RequestMethod.GET)
	public String story_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome story_selectAll...");
		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

		List<StoryVO> vos = service.s_selectAll(cpage, pageBlock);
		for (StoryVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);
		
//		 스토리 게시글에 들어있는 게시글
		int total_rows = service.s_getTotalRows();
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);
		

		return "story/selectAll";
	}
	
	@RequestMapping(value = "/s_increaseGood.do", method = RequestMethod.GET)
	public String rv_increaseGood(StoryVO vo) {
		
	
		return "story_increaseGood";
	}
	
	@RequestMapping(value = "/s_increaseGoodOK.do", method = RequestMethod.GET)
	public String rv_increaseGoodOK(StoryVO vo) {
		
	
		return "story_increaseGoodOK";
	}
	
	@RequestMapping(value = "/s_increaseReport.do", method = RequestMethod.GET)
	public String rv_increaseReport(StoryVO vo) {
		
	
		return "story_increaseReport";
	}
	
	@RequestMapping(value = "/s_increaseReportOK.do", method = RequestMethod.GET)
	public String rv_increaseReportOK(ReviewVO vo) {
		
	
		return "story_increaseReportOK";
	}
	
	
	
	
}