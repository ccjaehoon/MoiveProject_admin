package com.project.movieadmin.news.comments;

import java.util.List;

public interface NCommentsDAO {
	public int nc_insert(NCommentsVO vo);

	public int nc_update(NCommentsVO vo);

	public int nc_delete(NCommentsVO vo);

	public List<NCommentsVO> nc_selectAll(NCommentsVO vo);

	public int nc_increaseGood(NCommentsVO vo);
	
	public NCommentsVO nc_selectGood(NCommentsVO vo);
	
	public int nc_increaseReport(NCommentsVO vo);
}
