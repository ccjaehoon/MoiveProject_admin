package com.project.movie.news;

import java.util.List;

public interface NewsDAO {
	
	public List<NewsVO> n_selectAll(int cpage, int pageBlock);

	public NewsVO n_selectOne(NewsVO vo);

	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int n_insert(NewsVO vo);

	public int n_delete(NewsVO vo);

	public List<NewsVO> n_update(NewsVO vo);

	public int n_getTotalRows();

	public int n_getSearchTotalRows(String searchKey, String searchWord);
}
