package com.project.movieadmin.info.review;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int review_num;
	private int info_num;
	private String nickname;
	private String content;
	private Date wdate;
	private int good;
	private String report;
}
