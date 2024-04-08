package com.project.movieadmin.announcement;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AnnouncementVO {
	
	private int announcement_num;
	private String title;
	private String nickname;
	private String content;
	private Date date;
	private String authority;
	private String save_img;
	private MultipartFile file_img;

}
