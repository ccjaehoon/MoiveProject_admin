package com.project.movieadmin.news.comments;

import java.util.List;

public interface NCommentsDAO {
	public int insert(NCommentsVO vo);

	public int update(NCommentsVO vo);

	public int delete(NCommentsVO vo);

	public List<NCommentsVO> selectAll();

	public int nc_increaseGood(NCommentsVO vo);
}
