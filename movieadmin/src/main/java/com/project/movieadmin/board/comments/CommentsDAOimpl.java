package com.project.movieadmin.board.comments;

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
public class CommentsDAOimpl implements CommentsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int c_insert(CommentsVO vo) {
		log.info("c_insert()...");
		
		log.info("{}",vo);
		int flag = sqlSession.insert("INSERT", vo);
		return flag;
	}

	@Override
	public int c_update(CommentsVO vo) {
		log.info("c_update()...");

		int flag = sqlSession.update("UPDATE", vo);

		return flag;
	}

	@Override
	public int c_delete(CommentsVO vo) {
		log.info("c_delete()....");

		int flag = sqlSession.delete("DELETE", vo);

		return flag;
	}

	@Override
	public List<CommentsVO> c_selectAll(int cpage, int pageBlock) {
		log.info("c_selectAll()....");

		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);

		List<CommentsVO> vos = sqlSession.selectList("SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public int c_increaseGood(CommentsVO vo) {
		log.info("c_increaseGood()....");

		int total_rows = sqlSession.update("C_INCREASEGOOD", vo);

		return total_rows;
	}

	@Override
	public int c_increaseReport(CommentsVO vo) {
		log.info("c_increaseReport()....");

		int total_rows = sqlSession.update("C_INCREASEREPORT", vo);

		return total_rows;
	}

	@Override
	public List<CommentsVO> c_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		 int startRow = (cpage - 1) * pageBlock + 1;

	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("startRow", startRow - 1);
	        map.put("pageBlock", pageBlock);
	        map.put("vo", vo);

	        List<CommentsVO> vos = sqlSession.selectList("C_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
	        return vos;
	}

}
