package com.project.movieadmin.story;

import java.util.Date;
import java.util.List;

public interface StoryDAO {
	
	public int s_insert(StoryVO vo);

	public int s_update(StoryVO vo);

	public int s_delete(StoryVO vo);
	
	//public StoryVO selectOneRandom(StoryVO vo); 둘 중 어떤게 맞나요?
	public List<StoryVO> s_selectRandomList(StoryVO vo);
	
	public List<StoryVO> s_selectAll();
	
	public List<StoryVO> s_selectAll(int cpage,int pageBlock);
	
	public Date s_getLiveStories(StoryVO vo);
	
	public int s_removeExpired();

}
