package com.project.movieadmin.story.comments;
import lombok.Data;
import java.util.Date;

public class SCommentsVO {
	
	private int story_comments_num;
	private String nickname;	
	private String content;
	private Date wdate;
	private int good;
	private int story_num;
	private String report;
	
	public SCommentsVO() {
		// TODO Auto-generated constructor stub
	}

	public SCommentsVO(int story_comments_num, String nickname, String content, Date wdate, int good, int story_num,
			String report) {
		super();
		this.story_comments_num = story_comments_num;
		this.nickname = nickname;
		this.content = content;
		this.wdate = wdate;
		this.good = good;
		this.story_num = story_num;
		this.report = report;
	}

}
