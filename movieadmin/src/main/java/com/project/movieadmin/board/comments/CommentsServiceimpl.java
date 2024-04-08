package com.project.movieadmin.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentsServiceimpl implements CommentsService {

	@Autowired
	private CommentsDAO dao;
	
	public CommentsServiceimpl() {
		log.info("CommentsServiceimpl()...");
	}

	@Override
	public int c_insert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.c_insert(vo);
	}

	@Override
	public int c_update(CommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.c_update(vo);
	}

	@Override
	public int c_delete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.c_delete(vo);
	}

	@Override
	public List<CommentsVO> c_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return dao.c_selectAll(cpage, pageBlock);
	}

	@Override
	public int c_increaseGood(CommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.c_increaseGood(vo);
	}

	@Override
	public int c_increaseReport(CommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.c_increaseReport(vo);
	}
	
	

}
