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
		log.info("ReportDAOimpl()....");
	}

	@Override
	public List<ReportVO> rp_selectAll() {
		log.info("rp_selectAll()....");
		
		List<ReportVO> vos = sqlSession.selectList("RP_SELECT_ALL");
		return vos;
	}

	@Override
	public ReportVO rp_selectOne(ReportVO vo) {
		log.info("rp_selectOne()...");
		log.info(vo.toString());
		ReportVO vo2 = sqlSession.selectOne("RP_SELECT_ONE",vo);
		
		return vo2;
	}

	@Override
	public int rp_insert(ReportVO vo) {
		log.info("rp_insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("RP_INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int rp_delete(ReportVO vo) {
		log.info("rp_delete()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("RP_DELETE", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int rp_update(ReportVO vo) {
		log.info("rp_update()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("RP_UPDATE", vo);

		log.info("flag : {}", flag);

		return flag;
	}

}
