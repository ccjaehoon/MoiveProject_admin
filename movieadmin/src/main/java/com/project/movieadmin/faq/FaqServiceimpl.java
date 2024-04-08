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
	public int insert(FaqVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(FaqVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(FaqVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FaqVO selectOne(FaqVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
