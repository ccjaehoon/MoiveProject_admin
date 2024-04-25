package com.project.movieadmin.announcement;

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
public class AnnouncementDAOimpl implements AnnouncementDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int a_insert(AnnouncementVO vo) {
		
		int flag = sqlSession.insert("A_INSERT", vo);

		return flag;
	}

	@Override
	public int a_update(AnnouncementVO vo) {
		
		int flag = sqlSession.insert("A_UPDATE", vo);

		return flag;
	}

	@Override
	public int a_delete(AnnouncementVO vo) {
		
		int flag = sqlSession.insert("A_DELETE", vo);

		return flag;
	}

	@Override
	public AnnouncementVO a_selectOne(AnnouncementVO vo) {
		
		AnnouncementVO vo2 = sqlSession.selectOne("A_SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<AnnouncementVO> a_selectAll(int cpage, int pageBlock) {
		
		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);

		List<AnnouncementVO> vos = sqlSession.selectList("A_SELECT_ALL_PAGE_BLOCK", map);
		return vos;
	}

	@Override
	public List<AnnouncementVO> a_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		
		int startRow = (cpage - 1) * pageBlock + 1;
		log.info("startRow:{}", startRow);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<AnnouncementVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("A_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("content")) {
			vos = sqlSession.selectList("A_SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		}

		return vos;
	}

	@Override
	public int a_getTotalRows() {
		
		int total_rows = sqlSession.selectOne("A_TOTAL_ROWS");
		return total_rows;
	}

	@Override
	public int a_getSearchTotalRows(String searchKey, String searchWord) {
		
		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("A_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			total_rows = sqlSession.selectOne("A_SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

	@Override
	public List<AnnouncementVO> a_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		log.info("a_selectAll_nickname");
		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);
		map.put("vo", vo);

		List<AnnouncementVO> vos = sqlSession.selectList("A_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
		return vos;
	}

	@Override
	public List<AnnouncementVO> a_selectAll() {
		List<AnnouncementVO> vos = sqlSession.selectList("A_SELECT_ALL");
		return vos;
	}

}
