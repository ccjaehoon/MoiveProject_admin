package com.project.movieadmin.story.comments;

import java.util.Date;
import java.util.List;


public interface SCommentsDAO {
	
	public int sc_insert(SCommentsVO vo);

	public int sc_update(SCommentsVO vo);

	public int sc_delete(SCommentsVO vo);
	
	public List<SCommentsVO> sc_selectAll();
	
	public List<SCommentsVO> sc_selectAll(int cpage,int pageBlock);
	
	public Date s_getLiveStories(SCommentsVO vo);
	//만료되지 않은 스토리 조회
	public int s_removeExpiredComments();
	//만료된 스토리 댓글 삭제
	public int s_increaseGood(SCommentsVO vo); 
	//스토리 좋아요 수 증가
	
	public int s_increaseReport(SCommentsVO vo); 
	// 스토리 신고하기;

}
