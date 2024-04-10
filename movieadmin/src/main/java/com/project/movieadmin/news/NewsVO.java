package com.project.movieadmin.news;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NewsVO {
	private int news_num;
	private String title;
	private String nickname;
	private String content;
	private Date wdate;
	private int view;
	private String save_img;
	private MultipartFile file_img;
	private String save_video;
	private MultipartFile file_video;
}
