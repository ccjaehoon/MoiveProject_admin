package com.project.movieadmin.news.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class NCommentsDAOimpl implements NCommentsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int nc_insert(NCommentsVO vo) {
		log.info("newscomments insert()....");
		log.info(vo.toString());

		return sqlSession.insert("NC_INSERT", vo);
	}

	@Override
	public int nc_update(NCommentsVO vo) {
		log.info("newscomments update()....");
		log.info(vo.toString());

		return sqlSession.update("NC_UPDATE", vo);
	}

	@Override
	public int nc_delete(NCommentsVO vo) {
		log.info("newscomments delete()....");
		log.info(vo.toString());

		return sqlSession.delete("NC_DELETE", vo);
	}

	@Override
	public List<NCommentsVO> nc_selectAll(NCommentsVO vo) {
		log.info("newscomments selectAll()....");
		log.info(vo.toString());

		return sqlSession.selectList("NC_SELECT_ALL", vo);
	}

	@Override
	public int nc_increaseGood(NCommentsVO vo) {
		log.info("nc_increaseGood()....");
		log.info(vo.toString());
		return sqlSession.update("NC_INCREASE_GOOD", vo);
	}
	
	@Override
	public NCommentsVO nc_selectGood(NCommentsVO vo) {
		log.info("nc_selectGood()....");
		log.info(vo.toString());
		return sqlSession.selectOne("NC_SELECT_GOOD", vo);
	}


	@Override
	public int nc_increaseReport(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nc_goodCheck(NCommentsVO vo) {
		return sqlSession.selectOne("NC_GOOD_CHECK", vo);
	}

	@Override
	public int nc_goodSave(NCommentsVO vo) {
		return sqlSession.insert("NC_GOOD_SAVE", vo);
	}

}
