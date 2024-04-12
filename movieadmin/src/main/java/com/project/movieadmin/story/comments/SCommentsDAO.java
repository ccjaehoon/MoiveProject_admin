package com.project.movieadmin.story.comments;

import java.util.List;


public interface SCommentsDAO {
	
	public int sc_insert(SCommentsVO vo);

	public int sc_update(SCommentsVO vo);

	public int sc_delete(SCommentsVO vo);
	
	public List<SCommentsVO> sc_selectAll();
	
//	public List<SCommentsVO> sc_selectAll(int cpage,int pageBlock);
	
	public int s_increaseGood(SCommentsVO vo); 
	//스토리 댓글 좋아요 수 증가
	
	public int s_increaseReport(SCommentsVO vo); 
	// 스토리 댓글 신고하기;

}
