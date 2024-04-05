package com.project.movieadmin.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class NewsServiceimpl implements NewsService {
	
	@Autowired
	private NewsDAO dao;
	
	@Override
	public List<NewsVO> n_selectAll(int cpage, int pageBlock) {
		return dao.n_selectAll(cpage, pageBlock);
	}

	@Override
	public NewsVO n_selectOne(NewsVO vo) {
		return dao.n_selectOne(vo);
	}

	@Override
	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return dao.n_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int n_insert(NewsVO vo) {
		return dao.n_insert(vo);
	}

	@Override
	public int n_delete(NewsVO vo) {
		return dao.n_delete(vo);
	}

	@Override
	public List<NewsVO> n_update(NewsVO vo) {
		return dao.n_update(vo);
	}

	@Override
	public int n_getTotalRows() {
		return dao.n_getTotalRows();
	}

	@Override
	public int n_getSearchTotalRows(String searchKey, String searchWord) {
		return dao.n_getSearchTotalRows(searchKey, searchWord);
	}

}
