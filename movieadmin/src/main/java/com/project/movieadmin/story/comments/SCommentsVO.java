package com.project.movieadmin.story.comments;
import lombok.Data;


@Data
public class SCommentsVO {
	
	private int story_comments_num;
	private String nickname;	
	private String content;
	private String wdate;
	private int good;
	private int story_num;
	private int report;

}
