package com.project.movieadmin.info.review;

import java.util.List;

import com.project.movieadmin.info.InfoVO;

import com.project.movieadmin.user.UserVO;

public interface ReviewService {
	
	public int rv_insert(ReviewVO vo);

	public int rv_update(ReviewVO vo);

	public int rv_delete(ReviewVO vo);

	public List<ReviewVO> rv_selectAll(ReviewVO vo);

	public int rv_increaseGood(ReviewVO vo);
	
	public ReviewVO rv_selectGood(ReviewVO vo);

	public int rv_goodCheck(ReviewVO vo);

	public int rv_goodSave(ReviewVO vo);
	
	public List<ReviewVO> rv_selectAll_nickname(int cpage, int pageBlock, UserVO vo);
	
}
