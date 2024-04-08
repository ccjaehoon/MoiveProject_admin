package com.project.movieadmin.report;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReportDAOimpl implements ReportDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ReportDAOimpl() {
		log.info("NewsDAOimpl()....");
	}

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
