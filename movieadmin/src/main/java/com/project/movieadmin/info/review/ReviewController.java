package com.project.movieadmin.info.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.movieadmin.info.review.ReviewService;
import com.project.movieadmin.info.review.ReviewVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@Autowired
	private ServletContext sContext;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private InfoService comService;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/rv_insert.do", method = RequestMethod.GET)
	public String rv_insert(ReviewVO vo) {
		
		log.info("Welcome i_insert.do....");
		String nickname = (String) session.getAttribute("user_id");
		model.addAttribute(nickname);	
		return "rv_insert";
	}
	
	@RequestMapping(value = "/rv_insertOK.do", method = RequestMethod.GET)
	public String rv_insertOK(ReviewVO vo) {
		
		log.info("Welcome rv_insertOK.do...");
		log.info(vo.toString());

		String realPath = sContext.getRealPath("resources/uploadimg");
		log.info(realPath);

		String originName = vo.getFile_img().getOriginalFilename();

		log.info("getOriginalFilename:{}", originName);
		
		if (originName.length() == 0) {
			vo.setSave_img("default.png");
		} else {
			String save_img = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));

			vo.setSave_img(save_img);

			File uploadFile = new File(realPath, save_img);
			vo.getFile_img().transferTo(uploadFile);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_img);

			ImageIO.write(thumb_buffer_img, save_img.substring(save_img.lastIndexOf(".") + 1), thumb_file);

		}

		int result = service.rv_insert(vo);

		if (result == 1) {
			return "redirect:rv_selectAll.do";
		} else {
			return "redirect:rv_insert.do";
		}
	}
	
	
	
	@RequestMapping(value = "/rv_update.do", method = RequestMethod.GET)
	public String rv_update(ReviewVO vo) {
		
	
		return "rv_update";
	}
	
	@RequestMapping(value = "/rv_updateOK.do", method = RequestMethod.GET)
	public String rv_updateOK(ReviewVO vo) {
		
	
		return "rv_updateOK";
	}
	
	@RequestMapping(value = "/rv_delete.do", method = RequestMethod.GET)
	public String rv_delete(ReviewVO vo) {
		
	
		return "rv_delete";
	}
	
	@RequestMapping(value = "/rv_deleteOK.do", method = RequestMethod.GET)
	public String rv_deleteOK(ReviewVO vo) {
		
	
		return "rv_deleteOK";
	}
	
	
	@RequestMapping(value = "/rv_selectOne.do", method = RequestMethod.GET)
	public String rv_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "Review/rv_selectOne";
	}
	@RequestMapping(value = "/rv_selectAll.do", method = RequestMethod.GET)
	public String rv_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome selectAll!");
	
		return "Review/rv_selectAll";
	}
	@RequestMapping(value = "rv_searchList.do", method = RequestMethod.GET)
	public String rv_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		


		return "Review/rv_selectAll";
	}
	
	@RequestMapping(value = "/rv_increaseGood.do", method = RequestMethod.GET)
	public String rv_increaseGood(ReviewVO vo) {
		
	
		return "rv_increaseGood";
	}
	
	@RequestMapping(value = "/rv_increaseGoodOK.do", method = RequestMethod.GET)
	public String rv_increaseGoodOK(ReviewVO vo) {
		
	
		return "rv_increaseGoodOK";
	}
	
	@RequestMapping(value = "/rv_increaseReport.do", method = RequestMethod.GET)
	public String rv_increaseReport(ReviewVO vo) {
		
	
		return "rv_increaseReport";
	}
	
	@RequestMapping(value = "/rv_increaseReportOK.do", method = RequestMethod.GET)
	public String rv_increaseReportOK(ReviewVO vo) {
		
	
		return "rv_increaseReportOK";
	}
	
	
	
	
}