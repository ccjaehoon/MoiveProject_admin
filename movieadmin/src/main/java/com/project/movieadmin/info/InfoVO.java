package com.project.movieadmin.info;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class InfoVO {
	
	private int info_num;
	private String title;
	private String nickname;
	private String genre;
	private String directors;
	private String actor;
	private int showTime;
	private Date releaseDate;
	private String content;
	private String save_img;
	private MultipartFile file_img;
	private int views;
	private int recommends;
	private int watchGrade;
	private String companys;
	
}