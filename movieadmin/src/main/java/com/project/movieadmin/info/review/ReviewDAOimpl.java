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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_update(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_delete(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewVO> rv_selectAll(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rv_goodCheck(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_goodSave(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_increaseGood(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
