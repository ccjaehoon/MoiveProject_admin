package com.project.movie.report;

import java.util.List;

public interface ReportService {

	public List<ReportVO> rp_selectAll(int cpage, int pageBlock);

	public ReportVO rp_selectOne(ReportVO vo);

	public List<ReportVO> rp_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int rp_insert(ReportVO vo);

	public int rp_delete(ReportVO vo);

	public List<ReportVO> rp_update(ReportVO vo);

}
