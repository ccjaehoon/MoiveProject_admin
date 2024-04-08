package com.project.movieadmin.info.review;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private int info_num;
	private int review_num;
	private String content;
	private String nickname;
	private Date wdate;
	private int good;
	private String report;
}
