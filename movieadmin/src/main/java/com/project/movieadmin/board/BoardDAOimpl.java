package com.project.movieadmin.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOimpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public BoardDAOimpl() {
		log.info("BoardDAOimpl()....");
	}

	@Override
	public int b_insert(BoardVO vo) {
		log.info("b_insert()....");

		int flag = sqlSession.insert("INSERT", vo);

		return flag;
	}

	@Override
	public int b_update(BoardVO vo) {
		log.info("b_update()....");

		int flag = sqlSession.update("UPDATE", vo);

		return flag;
	}

	@Override
	public int b_delete(BoardVO vo) {
		log.info("b_delete()....");

		int flag = sqlSession.delete("DELETE", vo);

		return flag;
	}

	@Override
	public BoardVO b_selectOne(BoardVO vo) {
		log.info("b_selectOne()....");

		BoardVO vo2 = sqlSession.selectOne("SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<BoardVO> b_selectAll(int cpage, int pageBlock) {
		log.info("b_selectAll()....");

		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);

		List<BoardVO> vos = sqlSession.selectList("SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("b_searchList()...");

		int startRow = (cpage - 1) * pageBlock + 1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<BoardVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("nickname")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_NICKNAME", map);
		}

		return vos;
	}

	@Override
	public int b_getTotalRows() {
		log.info("b_getTotalRows()....");

		int total_rows = sqlSession.selectOne("TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public int b_getSearchTotalRows(String searchKey, String searchWord) {
		log.info("b_getSearchTotalRows()....");

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("nickname")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_NICKNAME", "%" + searchWord + "%");
		}

		return total_rows;
	}

	@Override
	public int b_increaseGood(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int b_increaseReport(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
