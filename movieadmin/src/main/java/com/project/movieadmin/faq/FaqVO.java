package com.project.movieadmin.faq;

import lombok.Data;

@Data
public class FaqVO {
	//주석
	private int faq_num;
	private String title;
	private String nickname;
	private String content;
	private String authority;
}
