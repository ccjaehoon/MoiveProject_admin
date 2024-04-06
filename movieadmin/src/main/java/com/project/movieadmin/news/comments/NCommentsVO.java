package com.project.movieadmin.news.comments;

import java.util.Date;

import lombok.Data;

@Data
public class NCommentsVO {
	private int news_comments_num;
	private String nickname;
	private String content;
	private Date wdate;
	private int good;
	private int news_board_num;
	private int report;
}
