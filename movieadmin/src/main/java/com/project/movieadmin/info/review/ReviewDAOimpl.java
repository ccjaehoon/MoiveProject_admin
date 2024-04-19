package com.project.movieadmin.info.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieadmin.news.comments.NCommentsVO;
import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReviewDAOimpl implements ReviewDAO {
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public int rv_insert(ReviewVO vo) {
		log.info("Review insert()....");
		log.info(vo.toString());

		return sqlSession.insert("RV_INSERT", vo);
	}

	@Override
	public int rv_update(ReviewVO vo) {
		log.info("Review update()....");
		log.info(vo.toString());

		return sqlSession.update("RV_UPDATE", vo);
	}

	@Override
	public int rv_delete(ReviewVO vo) {
		
		log.info("Review delete()....");
		log.info(vo.toString());

		return sqlSession.delete("RV_DELETE", vo);
	}

	@Override
	public List<ReviewVO> rv_selectAll(ReviewVO vo) {
		log.info("Review selectAll()....");
		log.info(vo.toString());

		return sqlSession.selectList("RV_SELECT_ALL", vo);
	}



	@Override
	public List<ReviewVO> rv_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		int startRow = (cpage - 1) * pageBlock + 1;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", startRow - 1);
        map.put("pageBlock", pageBlock);
        map.put("vo", vo);

        List<ReviewVO> vos = sqlSession.selectList("R_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
        return vos;
	}

	@Override
	public ReviewVO rv_selectGood(ReviewVO vo) {
		log.info("rv_selectGood()....");
		log.info(vo.toString());
		return sqlSession.selectOne("RV_SELECT_GOOD", vo);
	}

	@Override
	public int rv_goodCheck(ReviewVO vo) {
		return sqlSession.selectOne("RV_GOOD_CHECK", vo);
	}

	@Override
	public int rv_goodSave(ReviewVO vo) {
		return sqlSession.insert("RV_GOOD_SAVE", vo);
	}

	@Override
	public int rv_increaseGood(ReviewVO vo) {
		log.info("rv_increaseGood()....");
		log.info(vo.toString());
		return sqlSession.update("RV_INCREASE_GOOD", vo);
	}

}
