package com.project.movieadmin.news;

import java.util.List;

public class NewsDAOimpl implements NewsDAO {

	@Override
	public List<NewsVO> n_selectAll(int cpage, int pageBlock) {
		return null;
	}

	@Override
	public NewsVO n_selectOne(NewsVO vo) {
		return null;
	}

	@Override
	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return null;
	}

	@Override
	public int n_insert(NewsVO vo) {
		return 0;
	}

	@Override
	public int n_delete(NewsVO vo) {
		return 0;
	}

	@Override
	public List<NewsVO> n_update(NewsVO vo) {
		return null;
	}

	@Override
	public int n_getTotalRows() {
		return 0;
	}

	@Override
	public int n_getSearchTotalRows(String searchKey, String searchWord) {
		return 0;
	}

}
