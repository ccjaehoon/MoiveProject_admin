package com.project.movieadmin.news;

import java.util.List;

import com.project.movieadmin.user.UserVO;


public interface NewsService {

	public List<NewsVO> n_selectAll();
	
	public List<NewsVO> n_selectAll(int cpage, int pageBlock);

	public NewsVO n_selectOne(NewsVO vo);

	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int n_insert(NewsVO vo);

	public int n_delete(NewsVO vo);

	public int n_update(NewsVO vo);
	
	public int n_getTotalRows();
	public int n_getSearchTotalRows(String searchKey, String searchWord);

	public List<NewsVO> n_selectAll_nickname(int cpage, int pageBlock, UserVO vo);
	
}
