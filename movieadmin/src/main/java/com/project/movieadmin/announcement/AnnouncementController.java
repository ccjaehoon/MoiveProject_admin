package com.project.movieadmin.announcement;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService service;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext sContext;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/a_insert.do", method = RequestMethod.GET)
	public String u_insert() {

		return "announcement/insert";
	}
	
	@RequestMapping(value = "/a_insertOK.do", method = RequestMethod.GET)
	public String a_insertOK(AnnouncementVO vo) throws IllegalStateException, IOException {
		
	
	
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
	
		int result = service.a_insert(vo);
		
		if (result == 1) {
			return "redirect:a_selectAll.do";
		} else {
			return "redirect:a_insert.do";
		}
	}
	
	
	
	@RequestMapping(value = "/a_update.do", method = RequestMethod.GET)
	public String a_update(AnnouncementVO vo, Model model) {
	

		return "announcement/update";
	}
	@RequestMapping(value = "/a_updateOK.do", method = RequestMethod.GET)
	public String a_updateOK(AnnouncementVO vo, Model model) throws IllegalStateException, IOException {
		
			
		String realPath = sContext.getRealPath("resources/uploadimg");
		
	
		String originName = vo.getFile_img().getOriginalFilename();
	
		log.info("getOriginalFilename:{}", originName);
		
		if (originName.length() == 0) {
			vo.setSave_img("default.png");
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
	
			vo.setSave_img(save_name);
	
			File uploadFile = new File(realPath, save_name);
			try {
				vo.getFile_img().transferTo(uploadFile);
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
		
			BufferedImage original_buffer_img = ImageIO.read(uploadFile);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);
	
			File thumb_file = new File(realPath, "thumb_" + save_name);
	
			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);
	
		}
	
		int result = service.a_update(vo);
	
		if (result == 1) {
			return "redirect:a_selectOne.do?announcement_num=" + vo.getAnnouncement_num();
		} else {
			return "redirect:a_update.do?announcement_num=" + vo.getAnnouncement_num();
		}
	}
	@RequestMapping(value = "/a_delete.do", method = RequestMethod.GET)
	public String a_delete() {
		

		return "announcement/delete";
	}
	@RequestMapping(value = "/a_deleteOK.do", method = RequestMethod.GET)
	public String a_deleteOK(AnnouncementVO vo) {
		

		return "announcement/deleteOK";
	}
	
	@RequestMapping(value = "/a_selectOne.do", method = RequestMethod.GET)
	public String a_selectOne(int cpage, int pageBlock, Model model) {
		
	
		return "announcement/selectOne";
	}
	@RequestMapping(value = "/a_selectAll.do", method = RequestMethod.GET)
	public String a_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		
	
		return "announcement/selectAll";
	}
	@RequestMapping(value = "a_searchList.do", method = RequestMethod.GET)
	public String a_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		


		return "announcement/selectAll";
	}
	
}
