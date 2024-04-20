package com.project.movieadmin.board;

<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
=======
import java.sql.Date;

>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
public class BoardVO {
<<<<<<< HEAD
	private int board_num;
	private String title;
	private String tag;
	private String nickname;
	private String user_id;
	private String content;
	private java.util.Date wdate;
	private int good;
	private String authority;
	private int views;
	private int commentscount;
	private int report;
	private String save_img;
	private MultipartFile file_img;
//	private String save_video;
//	private MultipartFile file_video;
=======
	
	private int board_num;
	private String title;
	private String tag;
	private String nickname;
	private String content;
	private Date wdate;
	private int good;
	private String authority;
	private int views;
	private int commentscount;
	private String report;
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin

}
