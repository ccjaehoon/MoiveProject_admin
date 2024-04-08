package com.project.movieadmin.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FaqServiceimpl implements FaqService {

	@Autowired
	private FaqDAO dao;
	
	public FaqServiceimpl() {
		log.info("FaqServiceimpl()");
	}
	
	@Override
	public int f_insert(FaqVO vo) {
		return dao.f_insert(vo);
	}

	@Override
	public int f_update(FaqVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int f_delete(FaqVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FaqVO f_selectOne(FaqVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> f_selectAll(int cpage, int pageBlock) {
		return dao.f_selectAll(cpage, pageBlock);
	}

	@Override
	public List<FaqVO> f_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int f_getTotalRows() {
		return dao.f_getTotalRows();
	}

	@Override
	public int f_getSearchTotalRows(String searchKey, String searchWord) {
		return dao.f_getSearchTotalRows(searchKey, searchWord);
	}

}
