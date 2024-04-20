package com.project.movieadmin.board.comments;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
=======
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
public class CommentsServiceimpl implements CommentsService {

<<<<<<< HEAD
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
=======
	@Override
	public int c_insert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int c_update(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int c_delete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentsVO> c_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int c_increaseGood(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
	}

}
