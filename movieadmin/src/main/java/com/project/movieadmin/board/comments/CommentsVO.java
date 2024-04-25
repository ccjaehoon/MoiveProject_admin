package com.project.movieadmin.board.comments;




import lombok.Data;

@Data
public class CommentsVO {
	private int comments_num;
	private String nickname;
	private String content;
	private String wdate;
	private int good;
	private int board_num;
	private int report;

}
