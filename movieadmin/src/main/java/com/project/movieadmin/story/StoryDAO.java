package com.project.movieadmin.story;

import java.util.List;

import com.project.movieadmin.user.UserVO;


public interface StoryDAO {
	
	public int s_insert(StoryVO vo);

	public int s_update(StoryVO vo);

	public int s_delete(StoryVO vo);
	
	public StoryVO s_selectOne(StoryVO vo);
	public StoryVO s_selectRandomList(StoryVO vo);
	//public List<StoryVO> s_selectRandomList(StoryVO vo);
	
	public List<StoryVO> s_selectAll();
	
	public List<StoryVO> s_selectAll(int cpage,int pageBlock);
	
	public int s_getTotalRows();
	
	public List<StoryVO> s_getLiveStories();
	//만료되지 않은 스토리 조회
	public int s_removeExpired();
	//만료된 스토리 삭제
	public int s_increaseGood(StoryVO vo); 
	//스토리 좋아요 수 증가
	
	public void s_increaseGoodCount(StoryVO vo);
	//사용자가 이미 추천한 경우에는 추천 수를 증가시키지 않도록 로직을 구현하는 데 사용
	
	public int s_increaseReport(StoryVO vo); 
	// 스토리 신고하기

	public List<StoryVO> s_selectAll_nickname(int cpage, int pageBlock, UserVO vo);

}
