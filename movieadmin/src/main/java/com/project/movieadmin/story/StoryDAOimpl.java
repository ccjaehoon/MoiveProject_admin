package com.project.movieadmin.story;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StoryDAOimpl implements StoryDAO {
	@Override
	public int s_insert(StoryVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);
		int flag = 0;
		
		
		return flag;
	}

	@Override
	public int s_update(StoryVO vo) {
		System.out.println("update()....");
		System.out.println(vo);
		
		int flag = 0;
		
		
		return flag;
	}

	@Override
	public int s_delete(StoryVO vo) {
		System.out.println("delete()....");
		System.out.println(vo);
		int flag = 0;
		
		
		return flag;
	}
	
	@Override
	public List<StoryVO> s_selectRandomList(StoryVO vo) {
		System.out.println("s_selectRandomList()....");
		System.out.println(vo);
		List<StoryVO> vo2 = new ArrayList<StoryVO>();
		
		
		return vo2;
	}

	@Override
	public List<StoryVO> s_selectAll() {
		System.out.println("selectAll_Story()...");
		List<StoryVO> vos = new ArrayList<StoryVO>();
		
		
		return vos;
	}

	@Override
	public List<StoryVO> s_selectAll(int cpage, int pageBlock) {
		System.out.println("selectAll_Story(page)....");
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);
		List<StoryVO> vos = new ArrayList<StoryVO>();
		
		return vos;
	}

	@Override
	public Date s_getLiveStories(StoryVO vo) {
		System.out.println("getLiveStories....");
		
		
		return new Date();
	}

	@Override
	public int s_removeExpired() {
		System.out.println("s_removeExpired....");
		
		
		return 0;
	}

	@Override
	public int s_increaseGood(StoryVO vo) {
		System.out.println("s_increaseGood....");
		
		return 0;
	}

	@Override
	public int s_increaseReport(StoryVO vo) {
		System.out.println("s_increaseReport....");
		
		return 0;
	}


}
