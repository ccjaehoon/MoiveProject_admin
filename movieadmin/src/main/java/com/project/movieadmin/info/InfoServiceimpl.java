package com.project.movieadmin.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class InfoServiceimpl implements InfoService {
	
	@Autowired
	private InfoDAO dao;
	
	@Override
	public int i_insert(InfoVO vo) {
		
		return dao.i_insert(vo);
	}

	@Override
	public InfoVO i_selectOne(InfoVO vo) {
		
		return dao.i_selectOne(vo);
	}

	@Override
	public List<InfoVO> i_selectAll(int cpage, int pageBlock) {
		
		return dao.i_selectAll(cpage, pageBlock);
	}

	@Override
	public List<InfoVO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return dao.i_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int i_getTotalRows() {
		return dao.i_getTotalRows();
	}

	@Override
	public int i_getSearchTotalRows(String searchKey, String searchWord) {
		return dao.i_getSearchTotalRows(searchKey, searchWord);
	}

	@Override
	public int i_increaseRecommends(InfoVO vo) {
		return dao.i_increaseRecommends(vo);
	}

	@Override
	public int i_favoriteCheck(InfoVO vo) {
		
		return dao.i_favoriteCheck(vo);
	}

	@Override
	public int i_favoriteSave(InfoVO vo) {
		
		return dao.i_favoriteSave(vo);
	}

	@Override
	public int i_increaseViews(InfoVO vo) {
	
		return dao.i_increaseViews(vo);
	}

}