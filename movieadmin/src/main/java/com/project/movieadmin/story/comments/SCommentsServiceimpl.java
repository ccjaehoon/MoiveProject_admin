package com.project.movieadmin.story.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

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
	public List<SCommentsVO> sc_selectAll(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_selectAll(vo);
	}


	@Override
	public int sc_increaseGood(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_increaseGood(vo);
	}
	
	@Override
	public SCommentsVO sc_selectGood(SCommentsVO vo) {
		return dao.sc_selectGood(vo);
	}

	@Override
	public int sc_goodCheck(SCommentsVO vo) {
		return dao.sc_goodCheck(vo);
	}

	@Override
	public int sc_goodSave(SCommentsVO vo) {
		return dao.sc_goodSave(vo);
	}

	@Override
	public int sc_increaseReport(SCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_increaseReport(vo);
	}

	@Override
	public List<SCommentsVO> sc_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		// TODO Auto-generated method stub
		return dao.sc_selectAll_nickname(cpage, pageBlock, vo);
	}

}
