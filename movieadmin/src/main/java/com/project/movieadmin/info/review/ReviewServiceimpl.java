package com.project.movieadmin.info.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReviewServiceimpl implements ReviewService {
	
	@Autowired
	private ReviewDAO dao;

	@Override
	public int rv_insert(ReviewVO vo) {
		
		return dao.rv_insert(vo);
	}

	@Override
	public int rv_update(ReviewVO vo) {
		
		return dao.rv_update(vo);
	}

	@Override
	public int rv_delete(ReviewVO vo) {
		
		return dao.rv_delete(vo);
	}

	
	@Override
	public List<ReviewVO> rv_selectAll(ReviewVO vo) {
		
		return dao.rv_selectAll(vo);
	}

	@Override
	public int rv_increaseGood(ReviewVO vo) {
		
		return dao.rv_increaseGood(vo);
	}
	
	

	@Override
	public List<ReviewVO> rv_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		
		return dao.rv_selectAll_nickname(cpage, pageBlock, vo);
	}

	
	@Override
	public ReviewVO rv_selectGood(ReviewVO vo) {
		
		return dao.rv_selectGood(vo);
	}

	@Override
	public int rv_goodCheck(ReviewVO vo) {
		
		return dao.rv_goodCheck(vo);
	}

	@Override
	public int rv_goodSave(ReviewVO vo) {
		
		return dao.rv_goodSave(vo);
	}

	

}