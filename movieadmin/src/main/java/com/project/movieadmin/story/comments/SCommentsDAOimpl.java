package com.project.movieadmin.story.comments;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SCommentsDAOimpl implements SCommentsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public SCommentsDAOimpl() {
		log.info("SCommentsDAOimpl()....");
	}


	@Override
	public int sc_insert(SCommentsVO vo) {
		log.info("sc_insert()....");
		log.info(vo.toString());
		
		
		return sqlSession.insert("SC_INSERT", vo);
	}

	@Override
	public int sc_update(SCommentsVO vo) {
		log.info("sc_update()....");
		log.info(vo.toString());
		
		
		return sqlSession.update("SC_UPDATE", vo);
	}

	@Override
	public int sc_delete(SCommentsVO vo) {
		log.info("sc_delete()....");
		log.info(vo.toString());
		
		
		return sqlSession.delete("SC_DELETE", vo);
	}

	@Override
	public List<SCommentsVO> sc_selectAll() {
		log.info("sc_selectAll()....");
//		log.info(vo.toString());

		return sqlSession.selectList("SC_SELECT_ALL");
	}

//	@Override
//	public List<SCommentsVO> sc_selectAll(int cpage, int pageBlock) {
//		System.out.println("sc_selectAll(page)....");
//		System.out.println("cpage:" + cpage);
//		System.out.println("pageBlock:" + pageBlock);
//		List<SCommentsVO> vos = new ArrayList<SCommentsVO>();
//		
//		return vos;
//	}

	@Override
	public int s_increaseGood(SCommentsVO vo) {
		System.out.println("s_increaseGood....");
		
		
		return 0;
	}

	@Override
	public int s_increaseReport(SCommentsVO vo) {
		System.out.println("s_increaseReport.");
		
		
		return 0;
	}

}
