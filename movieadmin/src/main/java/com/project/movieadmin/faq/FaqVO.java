package com.project.movieadmin.faq;

import lombok.Data;

@Data
public class FaqVO {
	private int faq_num;
	private String title;
	private String nickname;
	private String content;
	private String authority;
}
