package com.project.movieadmin.story;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class StoryVO {
	
	private int story_num;
    private String nickname;
    private String storycontent;
    private String savename;
    private List<MultipartFile> image_files; // List of uploaded image files
    private List<MultipartFile> video_files; // List of uploaded video files
    private Date wdate;
    private int good;
    private int views;
    private Date duration; // 스토리가 표시되는 시간
    private String report;

    public StoryVO() {
        // TODO Auto-generated constructor stub
    }

	public StoryVO(int story_num, String nickname, String storycontent, String savename,
			List<MultipartFile> image_files, List<MultipartFile> video_files, Date wdate, int good, int views,
			Date duration, String report) {
		super();
		this.story_num = story_num;
		this.nickname = nickname;
		this.storycontent = storycontent;
		this.savename = savename;
		this.image_files = image_files;
		this.video_files = video_files;
		this.wdate = wdate;
		this.good = good;
		this.views = views;
		this.duration = duration;
		this.report = report;
	}
	

}
