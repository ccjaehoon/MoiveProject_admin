package com.project.movieadmin.board;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.movieadmin.board.comments.CommentsService;
import com.project.movieadmin.board.comments.CommentsVO;
import com.project.movieadmin.info.review.ReviewVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private ServletContext sContext;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CommentsService comService;

	public BoardController() {
		log.info("BoardController()....");
	}

	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert(Model model) {
		log.info("Welcome b_insert.do....");
		String nickname = (String) session.getAttribute("nickname");
		model.addAttribute(nickname);

		return "board/insert";
	}

	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.POST)
	public String b_insertOK(BoardVO vo) throws IllegalStateException, IOException {
		log.info("Welcome insertOK.do...");
		log.info(vo.toString());

		String realPath = sContext.getRealPath("resources/uploadimg");
		log.info(realPath);

		String originName = vo.getFile_img().getOriginalFilename();

		log.info("getOriginalFilename:{}", originName);

		if (originName.length() == 0) {
			vo.setSave_img("default.png");// 이미지선택없이 처리할때
		} else {
			String save_img = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));

			vo.setSave_img(save_img);

			File uploadFile = new File(realPath, save_img);
			vo.getFile_img().transferTo(uploadFile);// 원본 이미지저장

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_img);

			ImageIO.write(thumb_buffer_img, save_img.substring(save_img.lastIndexOf(".") + 1), thumb_file);

		}

		int result = service.b_insert(vo);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_insert.do";
		}
	}

	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome b_selectAll.do...");

		List<BoardVO> vos = service.b_selectAll(cpage, pageBlock);

		model.addAttribute("vos", vos);

		int total_rows = service.b_getTotalRows();

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}

		model.addAttribute("totalPageCount", totalPageCount);

		return "board/selectAll";
	}

	@RequestMapping(value = "/b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome b_searchList.do...");

		List<BoardVO> vos = service.b_searchList(searchKey, searchWord, cpage, pageBlock);

		model.addAttribute("vos", vos);

		int total_rows = service.b_getSearchTotalRows(searchKey, searchWord);
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

		return "board/selectAll";
	}

	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo, Model model) {
		log.info("Welcome b_selectOne.do...");
		BoardVO vo2 = service.b_selectOne(vo);

		model.addAttribute("vo2", vo2);
		log.info("vo2:{}", vo2);
		
		String nickname = (String) session.getAttribute("nickname");
		log.info("nickname: {}",nickname);
        // user_id를 모델에 추가하여 JSP로 전달
        model.addAttribute("nickname", nickname);		
		
		CommentsVO cvo = new CommentsVO();
		cvo.setBoard_num(vo.getBoard_num());
		cvo.setNickname(nickname);
		List<CommentsVO> cvos = comService.c_selectAll(cvo);
		
		model.addAttribute("cvos", cvos);
		
		return "board/selectOne";
	}

	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		log.info("Welcome b_update.do...");
		BoardVO vo2 = service.b_selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "board/update";
	}

	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.POST)
	public String b_updateOK(BoardVO vo) throws BindException {
		log.info("Welcome b_updateOK.do...");

		int result = service.b_update(vo);

		if (result == 1) {
			return "redirect:b_selectOne.do?board_num=" + vo.getBoard_num();
		} else {
			return "redirect:b_update.do?board_num=" + vo.getBoard_num();
		}
	}

	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("Welcome b_delete.do...");

		return "board/delete";
	}

	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.POST)
	public String b_deleteOK(BoardVO vo) {
		log.info("Welcome b_deleteOK.do...");
		log.info("vo:{}", vo);

		int result = service.b_delete(vo);
		log.info("result:", result);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_delete.do?board_num=" + vo.getBoard_num();
		}
	}
	

}
