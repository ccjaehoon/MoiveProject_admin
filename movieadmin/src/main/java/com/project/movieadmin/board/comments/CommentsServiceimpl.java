package com.project.movieadmin.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
public class CommentsServiceimpl implements CommentsService {

	@Autowired
	private CommentsDAO dao;

	@Override
	public int c_insert(CommentsVO vo) {
		return dao.c_insert(vo);
	}

	@Override
	public int c_update(CommentsVO vo) {
		return dao.c_update(vo);
	}

	@Override
	public int c_delete(CommentsVO vo) {
		return dao.c_delete(vo);
	}

	@Override
	public int c_increaseGood(CommentsVO vo) {
		return dao.c_increaseGood(vo);
	}

	@Override
	public List<CommentsVO> c_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		return dao.c_selectAll_nickname(cpage, pageBlock, vo);
	}

	@Override
	public List<CommentsVO> c_selectAll(CommentsVO vo) {
		return dao.c_selectAll(vo);
	}

	@Override
	public CommentsVO c_selectGood(CommentsVO vo) {
		return dao.c_selectGood(vo);
	}

	@Override
	public int c_goodCheck(CommentsVO vo) {
		return dao.c_goodCheck(vo);
	}

	@Override
	public int c_goodSave(CommentsVO vo) {
		return dao.c_goodSave(vo);
	}

}
