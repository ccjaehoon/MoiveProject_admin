package com.project.movieadmin.board.comments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommentsServiceimpl implements CommentsService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int c_insert(CommentsVO vo) {
		log.info("c_insert()...");

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
		// TODO Auto-generated method stub
		return 0;
	}

}
