package com.project.movieadmin.info.review;

import java.util.List;

public interface ReviewService {
	
	public int rv_insert(ReviewVO vo);
	
	public int rv_update(ReviewVO vo);
	
	public int rv_delete(ReviewVO vo);
	
	public ReviewVO rv_selectOne(ReviewVO vo);

	public List<ReviewVO> rv_selectAll(int cpage, int pageBlock);

	public int rv_getTotalRows();

	public int rv_getSearchTotalRows(String searchKey, String searchWord);
	
	public ReviewVO rv_increaseGood(ReviewVO vo);
	
	public ReviewVO rv_increaseReport(ReviewVO vo);
}
