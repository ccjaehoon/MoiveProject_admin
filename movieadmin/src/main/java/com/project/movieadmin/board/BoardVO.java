package com.project.movieadmin.board;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {
	
	private int board_num;
	private String title;
	private String tag;
	private String nickname;
	private String content;
	private Date wdate;
	private int good;
	private String authority;
	private int views;
	private int commentscount;
	private String report;
	private String save_name;
	private MultipartFile file;

}
