package com.project.movieadmin.story;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class StoryServiceimpl implements StoryService {
	
	@Autowired
	private StoryDAO dao;
	
	public StoryServiceimpl() { //생성자
		log.info("StoryDAOimpl()....");
	}
	@Override
	public int s_insert(StoryVO vo) {
		
		return dao.s_insert(vo);
	}

	@Override
	public int s_update(StoryVO vo) {
		
		return dao.s_update(vo);
	}

	@Override
	public int s_delete(StoryVO vo) {
		
		return dao.s_delete(vo);
	}
	
	@Override
	public List<StoryVO> s_selectRandomList(StoryVO vo) {
		
		return dao.s_selectRandomList(vo);
	}

	@Override
	public List<StoryVO> s_selectAll() {
		
		return dao.s_selectAll();
	}

	@Override
	public List<StoryVO> s_selectAll(int cpage, int pageBlock) {
		
		return dao.s_selectAll(cpage, pageBlock);
	}

	@Override
	public Date s_getLiveStories(StoryVO vo) {
		
		return dao.s_getLiveStories(vo);
	}

	@Override
	public int s_removeExpired() {
		System.out.println("s_removeExpired....");
		
		
		return 0;
	}

	@Override
	public int s_increaseGood(StoryVO vo) {
		
		return dao.s_increaseGood(vo);
	}

	@Override
	public int s_increaseReport(StoryVO vo) {

		return dao.s_increaseReport(vo);
	}


}