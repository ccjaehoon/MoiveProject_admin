package com.project.movieadmin.story.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCommentsServiceimpl implements SCommentsService {
	
	@Autowired
	private SCommentsDAO dao;

	@Override
	public int sc_insert(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_insert(vo);
	}

	@Override
	public int sc_update(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_update(vo);
	}

	@Override
	public int sc_delete(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_delete(vo);
	}

	@Override
	public List<SCommentsVO> sc_selectAll() {
		// TODO Auto-generated method stub
		return dao.sc_selectAll();
	}


	@Override
	public int sc_increaseGood(SCommentsVO vo) {
		// TODO Auto-generated method stub
		
		return 0;
//		return dao.sc_increaseGood(vo);
	}

	@Override
	public int sc_increaseReport(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
//		return dao.sc_increaseReport(vo);
	}

}
