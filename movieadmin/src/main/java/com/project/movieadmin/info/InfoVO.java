package com.project.movieadmin.info;

import java.sql.Date;

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
	private int showtime;
	private Date releaseDate;
	private String content;	
	private int views;
	private int recommends;
	private int watchGrade;
	private String companys;
	private String save_img;
	private MultipartFile file_img;
	private int good;
}