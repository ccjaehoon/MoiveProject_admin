package com.project.movieadmin.story;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

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
	public StoryVO s_selectOne(StoryVO vo) {
		
		return dao.s_selectOne(vo);
	}
	
	@Override
	public StoryVO s_selectRandomList(StoryVO vo) {
		
		return dao.s_selectRandomList(vo);
	}

	@Override
	public List<StoryVO> s_selectAll() {
		
		return dao.s_selectAll();
	}
	

	@Override
	public List<StoryVO> s_selectAll(int cpage, int pageBlock) {
		List<StoryVO> list=dao.s_selectAll(cpage,pageBlock);
		
		Collections.shuffle(list);
		return list;
		/* return dao.s_selectAll(cpage, pageBlock); */
	}
	
	@Override
	public int s_getTotalRows() {

		return dao.s_getTotalRows();
	}

	@Override
	public List<StoryVO> s_getLiveStories() {
		// 구현 로직
	    // 반환 타입이 List<StoryVO>인 객체를 반환
		 return dao.s_getLiveStories();
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
	public StoryVO s_selectGood(StoryVO vo) {
		return dao.s_selectGood(vo);
	}
	@Override
	public int s_goodCheck(StoryVO vo) {
		return dao.s_goodCheck(vo);
	}
	@Override
	public int s_goodSave(StoryVO vo) {
		return dao.s_goodSave(vo);
	}

	@Override
	public int s_increaseReport(StoryVO vo) {

		return dao.s_increaseReport(vo);
	}
	@Override
	public List<StoryVO> s_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		
		
		return dao.s_selectAll_nickname(cpage, pageBlock, vo);
	}


}