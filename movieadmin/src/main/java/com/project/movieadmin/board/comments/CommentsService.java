package com.project.movieadmin.board.comments;

import java.util.List;

import com.project.movieadmin.user.UserVO;

public interface CommentsService {
	
	public int c_insert(CommentsVO vo);

	public int c_update(CommentsVO vo);

	public int c_delete(CommentsVO vo);

	public List<CommentsVO> c_selectAll(int cpage, int pageBlock);
	
	public int c_getTotalRows();

	public int c_increaseGood(CommentsVO vo);
	
	public int c_increaseReport(CommentsVO vo);
	
	public List<CommentsVO> c_selectAll_nickname(int cpage, int pageBlock, UserVO vo);

}
