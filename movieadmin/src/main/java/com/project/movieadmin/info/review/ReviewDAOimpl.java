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
	public ReviewVO rv_selectOne(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewVO> rv_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rv_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rv_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewVO rv_increaseGood(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ReviewVO rv_increaseReport(ReviewVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewVO> r_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		int startRow = (cpage - 1) * pageBlock + 1;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", startRow - 1);
        map.put("pageBlock", pageBlock);
        map.put("vo", vo);

        List<ReviewVO> vos = sqlSession.selectList("R_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
        return vos;
	}

}
