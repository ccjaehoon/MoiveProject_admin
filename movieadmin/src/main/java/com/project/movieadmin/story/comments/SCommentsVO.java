package com.project.movieadmin.story.comments;
import lombok.Data;
import java.util.Date;

@Data
public class SCommentsVO {
	
	private int story_comments_num;
	private String nickname;	
	private String content;
	private Date wdate;
	private int good;
	private int story_num;
	private int report;

}
