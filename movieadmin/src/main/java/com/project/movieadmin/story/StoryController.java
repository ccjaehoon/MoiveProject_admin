package com.project.movieadmin.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.project.movieadmin.info.review.ReviewVO;
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
		//String realPath = sContext.getRealPath("resources/uploadimg"); 파일저장경로
		String imgRealPath = sContext.getRealPath("resources/uploadimg/images"); // 이미지 파일 저장 경로
		String videoRealPath = sContext.getRealPath("resources/uploadimg/videos");// 동영상 파일 저장 경로
// 이미지 파일과 동영상 파일이 모두 없는 경우에 대한 처리
	    if (vo.getFile() == null || vo.getFile().isEmpty()) {
	        log.error("이미지 파일과 동영상 파일이 모두 없습니다.");
	        return "redirect:s_insert.do"; // 글 작성 페이지로 리다이렉트
	    }
//  이미지 파일
	    if (vo.getFile() == null || vo.getFile().isEmpty()) {
	        log.info("이미지 파일이 없거나 비어 있습니다.");  
	    } else { // 이미지 파일의 원본 파일명을 가져옵니다.
	    	String originFileName = vo.getFile().getOriginalFilename();
	        log.info("업로드된 파일이 image", originFileName);
	     // 이미지 파일의 확장자 목록
		    List<String> imageExtensions = Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "webp");
		    List<String> videoExtensions = Arrays.asList("mp3", "mp4", "avi", "mov", "flv", "mkv");
		   /*  오디오 파일 확장자 목록 (나중에 추가해보자 원래는 비디오에 mp3 파일을 안 넣는다 함)
		    List<String> audioExtensions = new ArrayList<>(Arrays.asList("mp3", "wav", "flac", "ogg", "aac"));
		    audioExtensions.add("dsd"); */

		 // 파일 확장자 추출  +1을 사용한 이유는 파일 확장자의 점(.)을 제외하고 확장자 부분만 추출하기 위함
		    String fileExtension = originFileName.substring(originFileName.lastIndexOf(".") + 1).toLowerCase();
		    
		 // 파일 유형 판별
		    if (imageExtensions.contains(fileExtension)) {
		        // 이미지 파일 처리
		        String save_name = "img_" + System.currentTimeMillis() + originFileName.substring(originFileName.lastIndexOf("."));
		        vo.setSave_img(save_name);
		        File uploadFile = new File(imgRealPath, save_name);
		        vo.getFile().transferTo(uploadFile); // 이미지 파일 저장
		        
		        //이미지썸네일 생성로직 original_buffer_img = 이미지 파일을 읽어 메모리에 로드한 상태의 이미지
		        BufferedImage original_buffered_img = ImageIO.read(uploadFile);	        
		        int type = original_buffered_img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original_buffered_img.getType();
		        //썸네일의 크기를 지정합니다
		        int thumbnailWidth = 50;
		        int thumbnailHeight = 50;
		        
		        BufferedImage thumb_buffered_img = new BufferedImage(thumbnailWidth, thumbnailHeight, type);
		        Graphics2D graphic = thumb_buffered_img.createGraphics();
		        graphic.drawImage(original_buffered_img, 0, 0, thumbnailWidth, thumbnailHeight, null);
		        graphic.dispose(); // 리소스 해제

		        File thumb_file = new File(imgRealPath, "thumb_" + save_name);
		        ImageIO.write(thumb_buffered_img, "webp", thumb_file);
		       
		        
//  동영상 파일		        
		    }else if (videoExtensions.contains(fileExtension)) {
		        // 이미지 파일이 아닌 경우 처리
		        log.info("업로드된 파일이 video 파일입니다: {}", originFileName);
		        
		        String save_name = "video_" + System.currentTimeMillis() + originFileName.substring(originFileName.lastIndexOf("."));
		        vo.setSave_video(save_name);
		        File uploadFile = new File(videoRealPath, save_name);
		        vo.getFile().transferTo(uploadFile); // 이미지 파일 저장
		        
//			     // 썸네일 생성 코드 추가
				FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(uploadFile.getAbsolutePath());
				frameGrabber.start();
				Java2DFrameConverter converter = new Java2DFrameConverter();
		        
				Frame frame = frameGrabber.grabKeyFrame();
		        BufferedImage thumb_buffered_video = converter.convert(frame);
		        
		        // 썸네일의 크기를 지정합니다. resizedThumbnail =  동영상에서 추출된 썸네일 이미지
		        int thumbnailWidth = 50;
		        int thumbnailHeight = 50;
		        BufferedImage resizedThumbnail = new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_3BYTE_BGR);
		        
		        // Graphics2D 객체를 사용하여 원본 이미지를 새로운 크기로 그립니다.
		        Graphics2D graphic = resizedThumbnail.createGraphics();
		        graphic.drawImage(thumb_buffered_video, 0, 0, thumbnailWidth, thumbnailHeight, null);
		        graphic.dispose(); //리소스 해제
		        
		        // 조정된 썸네일을 파일에 저장합니다.
		        ImageIO.write(resizedThumbnail, "png", new File(videoRealPath, "thumb_" + save_name + ".png"));	        
		  }   
	    }

		 // 이미지 파일 처리 로직 및 동영상 파일 처리 로직 추가
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
		log.info("vo:{}", vo); //StoryVO 객체의 상태를 로그로 남기는 데 사용
		
		StoryVO vo2 = service.s_selectOne(vo);
		model.addAttribute("vo2", vo2);
		
		return "story/update";
	}
	@RequestMapping(value = "/s_updateOK.do", method = RequestMethod.POST)
	public String s_updateOK(StoryVO vo) {
		log.info("Welcome story_updateOK...");
		log.info("vo:{}", vo);
		String imgRealPath = sContext.getRealPath("resources/uploadimg/images"); // 이미지 파일 저장 경로

		String videoRealPath = sContext.getRealPath("resources/uploadimg/videos");// 동영상 파일 저장 경로
	    // 새 파일 업로드 로직


		int result = service.s_update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:s_selectOne.do?num=" + vo.getStory_num();
		} else {
			return "redirect:s_update.do?num=" + vo.getStory_num();
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
	
	@ResponseBody
	@RequestMapping(value = "/s_increaseGood.do", method = RequestMethod.GET)
	public String s_increaseGood(StoryVO vo, HttpSession session) {
		log.info("s_increaseGood:{}" , vo);
	
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