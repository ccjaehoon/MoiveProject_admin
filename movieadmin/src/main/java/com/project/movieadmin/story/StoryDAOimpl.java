package com.project.movieadmin.story;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StoryDAOimpl implements StoryDAO {
	
	@Autowired
	private SqlSession sqlSession; //전역변수
	
	@Override
	public int s_insert(StoryVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		return sqlSession.insert("S_INSERT", vo);
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
