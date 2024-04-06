package com.project.movieadmin.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceimpl implements ReportService {
	@Autowired
	private ReportDAO dao;
	
	@Override
	public List<ReportVO> rp_selectAll(int cpage, int pageBlock) {
		return dao.rp_selectAll(cpage, pageBlock);
	}

	@Override
	public ReportVO rp_selectOne(ReportVO vo) {
		return dao.rp_selectOne(vo);
	}

	@Override
	public List<ReportVO> rp_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return dao.rp_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int rp_insert(ReportVO vo) {
		return dao.rp_insert(vo);
	}

	@Override
	public int rp_delete(ReportVO vo) {
		return dao.rp_delete(vo);
	}

	@Override
	public List<ReportVO> rp_update(ReportVO vo) {
		return dao.rp_update(vo);
	}

}
