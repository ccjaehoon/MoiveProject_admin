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
	public InfoDAO i_selectOne(InfoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoDAO> i_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoDAO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int i_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int i_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int i_increaseRecommends(InfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}