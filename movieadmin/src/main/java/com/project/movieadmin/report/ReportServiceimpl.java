package com.project.movieadmin.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceimpl implements ReportService {
	@Autowired
	private ReportDAO dao;
	
	@Override
	public List<ReportVO> rp_selectAll() {
		return dao.rp_selectAll();
	}

	@Override
	public ReportVO rp_selectOne(ReportVO vo) {
		return dao.rp_selectOne(vo);
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
	public int rp_update(ReportVO vo) {
		return dao.rp_update(vo);
	}

}
