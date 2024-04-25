package com.project.movieadmin.info;

import java.util.List;

import com.project.movieadmin.user.UserVO;

public interface InfoDAO {

	public int i_insert(InfoVO vo);

	public InfoVO i_selectOne(InfoVO vo);
	
	public List<InfoVO> i_selectAll();

	public List<InfoVO> i_selectAll(int cpage, int pageBlock);

	public List<InfoVO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int i_getTotalRows();

	public int i_getSearchTotalRows(String searchKey, String searchWord);

	public int i_increaseRecommends(InfoVO vo);

	public int i_favoriteCheck(InfoVO vo);

	public int i_favoriteSave(InfoVO vo);

	public int i_increaseViews(InfoVO vo);

	public int i_getFavorite(InfoVO vo);

	public List<InfoVO> i_selectAll_nickname(int cpage, int pageBlock, UserVO vo);

	public int i_update(InfoVO vo);

}