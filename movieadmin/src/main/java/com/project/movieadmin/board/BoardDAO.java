package com.project.movieadmin.board;

import java.util.List;

<<<<<<< HEAD
import com.project.movieadmin.user.UserVO;

=======
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
public interface BoardDAO {
	
	public int b_insert(BoardVO vo);

	public int b_update(BoardVO vo);

	public int b_delete(BoardVO vo);

	public BoardVO b_selectOne(BoardVO vo);

	public List<BoardVO> b_selectAll(int cpage, int pageBlock);

	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int b_getTotalRows();
	
	public int b_getSearchTotalRows(String searchKey, String searchWord);
<<<<<<< HEAD
	
	public int b_increaseGood(BoardVO vo); 
	
	public BoardVO b_selectGood(BoardVO vo);

	public int b_goodCheck(BoardVO vo);

	public int b_goodSave(BoardVO vo);
	
	public int b_increaseReport(BoardVO vo); 

	public List<BoardVO> b_selectAll_nickname(int cpage, int pageBlock,UserVO vo);
=======

	public int b_increaseGood(BoardVO vo);
>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin

}
