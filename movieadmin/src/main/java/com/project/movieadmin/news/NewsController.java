package com.project.movieadmin.news;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movieadmin.news.comments.NCommentsService;
import com.project.movieadmin.news.comments.NCommentsVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class NewsController {

	@Autowired
	private NewsService service;
	
	@Autowired
	private NCommentsService comService;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/n_selectAll.do", method = RequestMethod.GET)
	public String n_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome n_selectAll.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

//		List<MemberVO> vos = service.selectAll();
		List<NewsVO> vos = service.n_selectAll(cpage, pageBlock);
		for (NewsVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);

		// member테이블에 들어있는 모든회원수는 몇명?
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
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "news/selectAll";
	}

	@RequestMapping(value = "/n_selectOne.do", method = RequestMethod.GET)
	public String n_selectOne(NewsVO vo, Model model) {
		log.info("n_selectOne.do");
		NewsVO vo2 = service.n_selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		model.addAttribute("vo2", vo2);

		// 댓글목록 처리로직
		NCommentsVO cvo = new NCommentsVO();
		cvo.setNews_num(vo.getNews_num());
		List<NCommentsVO> cvos = comService.nc_selectAll(cvo);

		model.addAttribute("cvos", cvos);

		return "news/selectOne";
	}

	@RequestMapping(value = "/n_searchList.do", method = RequestMethod.GET)
	public String n_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("n_searchList.do");
		List<NewsVO> vos = service.n_searchList(searchKey, searchWord, cpage, pageBlock);
		for (NewsVO x : vos) {
			log.info(x.toString());
		}
		System.out.println("================");

		model.addAttribute("vos", vos);

		// 키워드검색 모든회원수는 몇명?
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
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);
		return "news/selectAll";
	}

	@RequestMapping(value = "/n_insert.do", method = RequestMethod.GET)
	public String n_insert() {
		log.info("n_insert.do");

		return "news/insert";
	}

	@RequestMapping(value = "/n_insertOK.do", method = RequestMethod.POST)
	public String n_insertOK(NewsVO vo) throws IllegalStateException, IOException {
		log.info("Welcome n_insert...");
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

		int result = service.n_insert(vo);
		if (result == 1) {
			return "redirect:n_selectAll.do";
		} else {
			return "redirect:n_insert.do";
		}
	}

	@RequestMapping(value = "/n_delete.do", method = RequestMethod.GET)
	public String n_delete() {
		log.info("n_delete.do");

		return "news/delete";
	}

	@RequestMapping(value = "/n_deleteOK.do", method = RequestMethod.POST)
	public String n_deleteOK(NewsVO vo) {
		log.info("Welcome n_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.n_delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:n_selectAll.do";
		} else {
			return "redirect:n_delete.do?news_num=" + vo.getNews_num();
		}

	}

	@RequestMapping(value = "/n_update.do", method = RequestMethod.GET)
	public String n_update() {
		log.info("n_update.do");

		return "news/update";
	}

	@RequestMapping(value = "/n_updateOK.do", method = RequestMethod.POST)
	public String n_updateOK(NewsVO vo, Model model) throws IllegalStateException, IOException {
		log.info("Welcome n_updateOK.do....");

		log.info("" + vo);

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

		int result = service.n_update(vo);
		log.info("result:" + result);
		System.out.println("================");

		if (result == 1) {
			return "redirect:n_selectOne.do?news_num=" + vo.getNews_num();
		} else {
			return "redirect:n_update.do?news_num=" + vo.getNews_num();
		}
	}

}
