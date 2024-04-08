package com.project.movieadmin.story;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class StoryVO {
	
	private int story_num;
    private String nickname;
    private String content;
    private String save_img;
    private String save_video;
    private MultipartFile file_img; // List of uploaded image files
    private MultipartFile file_video; // List of uploaded video files
    private Date wdate;
    private int good;
    private int views;
    private Date duration; // 스토리가 표시되는 시간
    private String report;

   
	
}
