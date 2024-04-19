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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_update(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_delete(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewVO rv_selectOne(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int rv_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewVO rv_increaseGood(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ReviewVO rv_increaseReport(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewVO> r_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		// TODO Auto-generated method stub
		return dao.r_selectAll_nickname(cpage, pageBlock, vo);
	}

	@Override
	public List<ReviewVO> rv_selectAll(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}