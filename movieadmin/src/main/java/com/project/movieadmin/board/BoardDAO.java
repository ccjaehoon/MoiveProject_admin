package com.project.movieadmin.board;

import java.util.List;

import com.project.movieadmin.news.comments.NCommentsVO;
import com.project.movieadmin.user.UserVO;

public interface BoardDAO {
	
	public int b_insert(BoardVO vo);

	public int b_update(BoardVO vo);

	public int b_delete(BoardVO vo);

	public BoardVO b_selectOne(BoardVO vo);

	public List<BoardVO> b_selectAll(int cpage, int pageBlock);

	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int b_getTotalRows();
	
	public int b_getSearchTotalRows(String searchKey, String searchWord);
	
	public int b_increaseGood(BoardVO vo);
	
	public NCommentsVO b_selectGood(BoardVO vo);
	
	public int b_increaseReport(BoardVO vo);
	
	public int b_goodCheck(BoardVO vo);

	public int b_goodSave(BoardVO vo);

	public List<BoardVO> b_selectAll_nickname(int cpage, int pageBlock,UserVO vo);

}
