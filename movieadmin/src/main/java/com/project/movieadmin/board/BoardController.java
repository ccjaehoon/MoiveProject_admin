package com.project.movieadmin.board;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	public BoardController() {
		log.info("BoardController()....");
	}

	@RequestMapping(value = "b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		log.info("Welcome insert.do....");

		return "board/insert";
	}

	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.GET)
	public String b_insertOK(BoardVO vo) throws IllegalStateException, IOException {
		log.info("Welcome insertOK.do...");

		String realPath = sContext.getRealPath("resources/uploadimg");

		MultipartFile file = vo.getFile_img();
		String originName = file.getOriginalFilename();
		if (file != null) {
			originName = file.getOriginalFilename();
		}
		if (originName.length() == 0) {
			vo.setSave_img("default.png"); // 기본이미지
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));

			vo.setSave_img(save_name);

			File uploadFile = new File(realPath, save_name);
			vo.getFile_img().transferTo(uploadFile); // 원본 이미지 저장

			// 썸네일 이미지
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

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

		return "board/searchList";
	}

	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo, Model model) {
		log.info("Welcome b_insert.do...");
		BoardVO vo2 = service.b_selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "board/selectOne";
	}

	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		log.info("Welcome b_update.do...");
		BoardVO vo2 = service.b_selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "board/update";
	}

	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.GET)
	public String b_updateOK(BoardVO vo) {
		log.info("Welcome b_updateOK.do...");

		int result = service.b_update(vo);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_update.do";
		}
	}

	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("Welcome b_delete.do...");

		return "board/delete";
	}

	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.GET)
	public String b_deleteOK(BoardVO vo) {
		log.info("Welcome b_deleteOK.do...");

		int result = service.b_delete(vo);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_delete.do";
		}
	}

}
