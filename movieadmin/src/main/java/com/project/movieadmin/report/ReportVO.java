package com.project.movieadmin.report;

import java.util.Date;

import lombok.Data;

@Data
public class ReportVO {
	private int report_num;
	private String nickname;
	private String content;
	private Date wdate;
	private int board_num;
	private int  comments_num;
	private Date handledate;
	
}
