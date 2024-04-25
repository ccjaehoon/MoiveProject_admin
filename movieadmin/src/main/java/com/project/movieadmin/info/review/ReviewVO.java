package com.project.movieadmin.info.review;



import lombok.Data;

@Data
public class ReviewVO {
	
	private int review_num;
	private int info_num;
	private String nickname;
	private String content;
	private String wdate;
	private int good;
	private String report;
}
