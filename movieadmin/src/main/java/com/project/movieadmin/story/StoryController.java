package com.project.movieadmin.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movieadmin.info.review.ReviewVO;
import com.project.movieadmin.news.NewsVO;
import com.project.movieadmin.news.comments.NCommentsService;
import com.project.movieadmin.news.comments.NCommentsVO;
import com.project.movieadmin.story.comments.SCommentsService;
import com.project.movieadmin.story.comments.SCommentsVO;

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
	
	@Autowired
	private SCommentsService comService;
	
	@Autowired
	private HttpSession session;
//이 객체는 웹 애플리케이션 전체에서 공유할 수 있는 정보를 유지하는 데 사용됩니다. 이를 통해 서블릿 간에 데이터를 공유하거나, 애플리케이션 수준의 설정 정보를 관리
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/s_insert.do", method = RequestMethod.GET)
	public String s_insert(Model model) {
		log.info("Welcome story_insert...");
		String nickname = (String) session.getAttribute("nickname");
		model.addAttribute(nickname);
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
		    // 동영상 파일 저장 코드 수정
		 if (vo.getFile_video() != null && !vo.getFile_video().isEmpty()) {
	        // 동영상 파일의 크기 제한 설정 (20MB)
	        final long MAX_FILE_SIZE = 20 * 1024 * 1024; // 20MB
	        
	        // 파일 크기 검증
	        if (vo.getFile_video().getSize() > MAX_FILE_SIZE) {
	            log.error("동영상 파일 크기가 허용된 용량을 초과합니다.");
	            // 크기 제한 초과 시 적절한 처리 (예: 사용자에게 메시지 반환 또는 예외 발생)
	            throw new IOException("동영상 파일 크기가 허용된 용량을 초과합니다.");
	        }
		
		
		    String videoName = vo.getFile_video().getOriginalFilename();
		    String saveVideoName = "video_" + System.currentTimeMillis() + videoName.substring(videoName.lastIndexOf("."));
		    vo.setSave_video(saveVideoName); // VO의 save_video 필드에 저장할 동영상 파일 이름을 설정
		    
		    // 동영상 파일 저장 경로 설정
		    File uploadVideoFile = new File(realPath, saveVideoName);
		    vo.getFile_video().transferTo(uploadVideoFile); // 동영상 파일 저장
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
		
//		 List<StoryVO> randomStories = service.s_selectRandomList(vo);
//		    if (!randomStories.isEmpty()) {
//		        StoryVO vo2 = randomStories.get(0); // 리스트의 첫 번째 요소를 선택
//		        log.info("vo2:{}", vo2);
//		        model.addAttribute("vo2", vo2);
//		 }
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
	@RequestMapping(value = "/s_deleteOK.do", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/s_selectOne.do", method = RequestMethod.GET)
	public String story_selectOne(StoryVO vo, Model model) {
		log.info("Welcome s_selectOne...");
//vo는 클라이언트로부터 받은 요청 데이터를 처리하기 위한 객체이며, vo2는 서비스 레이어에서 반환된 결과 데이터를 담음
		StoryVO vo2 = service.s_selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		model.addAttribute("vo2", vo2);
		
		String nickname = (String) session.getAttribute("nickname");
		
		log.info("nickname: {}",nickname);
        // user_id를 모델에 추가하여 JSP로 전달
        model.addAttribute("nickname", nickname);

     
		
		// 댓글목록 처리로직
        SCommentsVO cvo = new SCommentsVO();
        cvo.setStory_num(vo.getStory_num());
		List<SCommentsVO> cvos = comService.sc_selectAll(cvo);
		log.info(cvos.toString());

		model.addAttribute("cvos", cvos);

		return "story/selectOne";
	}
	
	@RequestMapping(value = "/s_selectRandomList.do", method = RequestMethod.GET)
	public String story_selectRandomList(StoryVO vo, Model model) {
		log.info("Welcome s_selectRandomList...");
		
		 // Random 객체 생성
        Random rand = new Random();
        // 예를 들어, 무작위로 선택할 스토리의 ID를 생성 (여기서는 1부터 10까지 가정)
        int storyId = rand.nextInt(10) + 1;
        
        // 무작위로 선택된 스토리 목록을 가져오는 서비스 메소드 호출
      //List<StoryVO> randomStories = service.s_selectRandomList(vo);
        StoryVO vo2 = service.s_selectRandomList(vo);
        log.info("vo2:{}",vo2);
        // 모델에 무작위 스토리 목록 추가
        model.addAttribute("vo2", vo2);

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
	public String s_increaseGood(StoryVO vo, HttpSession session) {
		log.info("s_increaseGood:{}" + vo);
	
		log.info("vo:{}",vo);
		
		int goodCount = service.s_increaseGood(vo);
	
		return "{\"goodCount\":\""+goodCount+"\"}";
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