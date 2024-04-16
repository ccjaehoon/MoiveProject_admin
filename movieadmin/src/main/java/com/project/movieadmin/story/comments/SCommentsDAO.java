package com.project.movieadmin.story.comments;

import java.util.List;

import com.project.movieadmin.news.comments.NCommentsVO;
import com.project.movieadmin.user.UserVO;


public interface SCommentsDAO {
	
	public int sc_insert(SCommentsVO vo);

	public int sc_update(SCommentsVO vo);

	public int sc_delete(SCommentsVO vo);
	
	public List<SCommentsVO> sc_selectAll();
	public List<SCommentsVO> sc_selectAll(SCommentsVO vo);
	
//	public List<SCommentsVO> sc_selectAll(int cpage,int pageBlock);
	
	public int sc_increaseGood(SCommentsVO vo); 
	//스토리 댓글 좋아요 수 증가
	
	public int sc_increaseReport(SCommentsVO vo); 
	// 스토리 댓글 신고하기;
	
	public List<SCommentsVO> sc_selectAll_nickname(int cpage, int pageBlock, UserVO vo);
	//댓글 목록을 조회하는 기능
}
