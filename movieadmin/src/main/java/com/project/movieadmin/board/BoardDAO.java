package com.project.movieadmin.board;

import java.util.List;

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

}
