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
    private MultipartFile file; // 여러 동영상과 이미지파일
    private Date wdate;
    private int good; //추천수
    private int views; //게시글 조회된 수
    private Date duration; // 스토리가 표시되는 시간
    private int report; //신고 수
}
