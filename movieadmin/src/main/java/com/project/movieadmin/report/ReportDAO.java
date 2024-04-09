package com.project.movieadmin.report;

import java.util.List;

public interface ReportDAO {

	public List<ReportVO> rp_selectAll();

	public ReportVO rp_selectOne(ReportVO vo);

	public int rp_insert(ReportVO vo);

	public int rp_delete(ReportVO vo);

	public int rp_update(ReportVO vo);

}
