package com.project.movieadmin.board;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
=======
import java.util.List;

>>>>>>> branch 'handmade' of https://github.com/ccjaehoon/MoiveProject_admin
public class BoardDAOimpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public BoardDAOimpl() {
		log.info("BoardDAOimpl()....");
	}

	@Override
	public int b_insert(BoardVO vo) {
		log.info("B_insert()....");

		log.info("{}",vo);
		int flag = sqlSession.insert("B_INSERT", vo);
		return flag;
	}

	@Override
	public int b_update(BoardVO vo) {
		log.info("B_update()....");

		int flag = sqlSession.update("B_UPDATE", vo);
		log.info("flag : {}", flag);
		return flag;
	}

	@Override
	public int b_delete(BoardVO vo) {
		log.info("B_delete()....");

		int flag = sqlSession.insert("B_DELETE", vo);
		
		return flag;
	}

	@Override
	public BoardVO b_selectOne(BoardVO vo) {
		log.info("B_selectOne()....");

		BoardVO vo2 = sqlSession.selectOne("B_SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<BoardVO> b_selectAll(int cpage, int pageBlock) {
		log.info("B_selectAll()....");

		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);

		List<BoardVO> vos = sqlSession.selectList("B_SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("B_searchList()...");

		int startRow = (cpage - 1) * pageBlock + 1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<BoardVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("B_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("nickname")) {
			vos = sqlSession.selectList("B_SEARCHLIST_PAGE_BLOCK_NICKNAME", map);
		}

		return vos;
	}

	@Override
	public int b_getTotalRows() {
		log.info("B_getTotalRows()....");

		int total_rows = sqlSession.selectOne("B_TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public int b_getSearchTotalRows(String searchKey, String searchWord) {
		log.info("B_getSearchTotalRows()....");

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("B_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("nickname")) {
			total_rows = sqlSession.selectOne("B_SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

	@Override
	public List<BoardVO> b_selectAll_nickname(int cpage, int pageBlock,UserVO vo) {
		log.info("B_selectAll()....");

		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);
		map.put("vo", vo);

		List<BoardVO> vos = sqlSession.selectList("B_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);

		return vos;
	}

	@Override
	public int b_increaseGood(BoardVO vo) {
		log.info("b_increaseGood()....");

		int total_rows = sqlSession.update("B_INCREASE_GOOD", vo);

		return total_rows;
	}

	@Override
	public BoardVO b_selectGood(BoardVO vo) {
		log.info("b_selectGood()....");
		log.info(vo.toString());
		return sqlSession.selectOne("B_SELECT_GOOD", vo);
	}

	@Override
	public int b_goodCheck(BoardVO vo) {
		return sqlSession.selectOne("B_GOOD_CHECK", vo);
	}

	@Override
	public int b_goodSave(BoardVO vo) {
		return sqlSession.insert("B_GOOD_SAVE", vo);
	}

	@Override
	public int b_increaseReport(BoardVO vo) {
		log.info("b_increaseReport()....");
		// 해당 게시물의 신고수를 가져와 1 증가시킴
	    int currentReportCount = vo.getReport();
	    vo.setReport(currentReportCount + 1);

	    // 데이터베이스에 업데이트
	    return sqlSession.update("B_UPDATE_REPORT_COUNT", vo);
	}

	@Override
	public int b_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int b_update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int b_delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO b_selectOne(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> b_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int b_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int b_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int b_increaseGood(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
