package com.project.movieadmin.story.comments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.movieadmin.story.StoryVO;


public class SCommentsDAOimpl implements SCommentsDAO {

	@Override
	public int sc_insert(SCommentsVO vo) {
		System.out.println("sc_insert()....");
		System.out.println(vo);
		int flag = 0;
		
		
		return flag;
	}

	@Override
	public int sc_update(SCommentsVO vo) {
		System.out.println("sc_update()....");
		System.out.println(vo);
		
		int flag = 0;
		
		
		return flag;
	}

	@Override
	public int sc_delete(SCommentsVO vo) {
		System.out.println("sc_delete()....");
		System.out.println(vo);
		int flag = 0;
		
		return flag;
	}

	@Override
	public List<SCommentsVO> sc_selectAll() {
		System.out.println("sc_selectAll()...");
		List<SCommentsVO> vos = new ArrayList<SCommentsVO>();
		
		
		return vos;
	}

	@Override
	public List<SCommentsVO> sc_selectAll(int cpage, int pageBlock) {
		System.out.println("sc_selectAll(page)....");
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);
		List<SCommentsVO> vos = new ArrayList<SCommentsVO>();
		
		return vos;
	}

	@Override
	public Date s_getLiveStories(SCommentsVO vo) {
		System.out.println("s_getLiveStories...");
		
		
		return new Date();
	}

	@Override
	public int s_removeExpiredComments() {
		System.out.println("s_removeExpiredComments...");
		
		
		return 0;
	}

	@Override
	public int s_increaseGood(SCommentsVO vo) {
		System.out.println("s_increaseGood....");
		
		
		return 0;
	}

	@Override
	public int s_increaseReport(SCommentsVO vo) {
		System.out.println("s_increaseReport.");
		
		
		return 0;
	}

}
