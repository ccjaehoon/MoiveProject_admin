package com.project.movieadmin.info;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.util.UriUtils;
import com.project.movieadmin.info.review.ReviewService;
import com.project.movieadmin.info.review.ReviewVO;
import lombok.extern.slf4j.Slf4j;
/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class InfoController {
	
	

	
	@Autowired
	private InfoService service;
	
	@Autowired
	private ReviewService inservice;
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletContext sContext;
	
	
	@RequestMapping(value = "/i_insert.do", method = RequestMethod.GET)
	public String i_insert(Model model) {
		log.info("Welcome i_insert.do....");
		String nickname = (String) session.getAttribute("user_id");
		model.addAttribute(nickname);
		return "info/insert";
	}
	
	
	
	@RequestMapping(value = "/i_insertOK.do", method = RequestMethod.POST)
	public String i_insertOK(InfoVO vo) throws IllegalStateException, IOException {
	   
	   
	    String realPath = sContext.getRealPath("resources/uploadimg");
		
		String originName = vo.getFile_img().getOriginalFilename();
	
		
		if (originName.length() == 0) {
			vo.setSave_img("default.png");
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			vo.setSave_img(save_name);
			File uploadFile = new File(realPath, save_name);
			vo.getFile_img().transferTo(uploadFile);
			
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);
			File thumb_file = new File(realPath, "thumb_" + save_name);
			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);
		}
	    int result = service.i_insert(vo);
	    if (result == 1) {
	        return "redirect:i_selectAll.do";
	    } else {
	        return "redirect:i_insert.do";
	    }
	}
	
	
	@RequestMapping(value = "/i_selectOne.do", method = RequestMethod.GET)
	public String i_selectOne(InfoVO vo, Model model) {
		
		
		InfoVO vo2=service.i_selectOne(vo);
		
		
		model.addAttribute("vo2", vo2);
		
		
		String nickname = (String) session.getAttribute("nickname");
		
		
		model.addAttribute("nickname", nickname);
		
		ReviewVO ivo = new ReviewVO();
		ivo.setInfo_num(vo.getInfo_num());
		ivo.setNickname(nickname);
		List<ReviewVO> ivos= inservice.rv_selectAll(ivo);
		service.i_increaseViews(vo);
		log.info(ivos.toString());
		model.addAttribute("ivos", ivos);
		
		return "info/selectOne";
	}
	
	@RequestMapping(value = "/i_selectAll.do", method = RequestMethod.GET)
	public String i_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "10") int pageBlock, Model model) {
	
		
		
		
		List<InfoVO> vos = service.i_selectAll(cpage, pageBlock);
		
		model.addAttribute("vos", vos);
		
		int total_rows = service.i_getTotalRows();
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
		
		String nickname = (String) session.getAttribute("nickname");
		log.info("nickname: {}",nickname);
		
		model.addAttribute("nickname", nickname);
		
		
		return "info/selectAll";
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
			
			int total_rows = service.i_getSearchTotalRows(searchKey, searchWord);
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
			
			e.printStackTrace();
		}
		
		
		return "info/selectAll";
	}
	
	@RequestMapping(value = "/i_update.do", method = RequestMethod.GET)
	public String i_update(InfoVO vo, Model model) {
		log.info("Welcome i_update...");
		log.info("vo:{}", vo);
		
		InfoVO vo2=service.i_selectOne(vo);
		log.info("vo2:" + vo2);
		
		model.addAttribute("vo2", vo2);
		
		return "info/update";
	}
	
	@RequestMapping(value = "/i_updateOK.do", method = RequestMethod.POST)
	public String i_updateOK(InfoVO vo, Model model) throws IllegalStateException, IOException {
		log.info("Welcome i_updateOK.do....");
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
		int result = service.i_update(vo);
		log.info("result:" + result);
		System.out.println("================");
		if (result == 1) {
			return "redirect:i_selectOne.do?info_num=" + vo.getInfo_num();
		} else {
			return "redirect:i_update.do?info_num=" + vo.getInfo_num();
		}
	}
	
	
}