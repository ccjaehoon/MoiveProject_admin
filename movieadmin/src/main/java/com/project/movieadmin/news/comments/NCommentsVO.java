package com.project.movieadmin.news.comments;



import lombok.Data;

@Data
public class NCommentsVO {
	private int news_comments_num;
	private String nickname;
	private String content;
	private String wdate;
	private int good;
	private int news_num;
	private int report;
}
