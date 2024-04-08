package com.project.movieadmin.report;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOimpl implements ReportDAO {

	@Override
	public List<ReportVO> rp_selectAll(int cpage, int pageBlock) {
		return null;
	}

	@Override
	public ReportVO rp_selectOne(ReportVO vo) {
		return null;
	}

	@Override
	public List<ReportVO> rp_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return null;
	}

	@Override
	public int rp_insert(ReportVO vo) {
		return 0;
	}

	@Override
	public int rp_delete(ReportVO vo) {
		return 0;
	}

	@Override
	public List<ReportVO> rp_update(ReportVO vo) {
		return null;
	}

}
