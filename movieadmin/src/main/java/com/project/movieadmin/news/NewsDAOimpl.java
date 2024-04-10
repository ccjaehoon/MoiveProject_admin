package com.project.movieadmin.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class NewsDAOimpl implements NewsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public NewsDAOimpl() {
		log.info("NewsDAOimpl()....");
	}

	@Override
	public List<NewsVO> n_selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		
		log.info("startRow:{}",startRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);

		List<NewsVO> vos = sqlSession.selectList("N_SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public NewsVO n_selectOne(NewsVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		NewsVO vo2 = sqlSession.selectOne("N_SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....4");
		log.info(searchKey);
		log.info(searchWord);

		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		log.info("startRow:{}",startRow);

		//주의: 맵핑할때 서로다른 타입의 정보를 넣을때는 Object타입으로 설정해주면된다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);//mysql은 시작행 0행 -1처리 필요
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<NewsVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("N_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("content")) {
			vos = sqlSession.selectList("N_SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		}

		return vos;
	}

	@Override
	public int n_insert(NewsVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("N_INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int n_delete(NewsVO vo) {
		log.info("delete()....");
		log.info(vo.toString());

		int flag = sqlSession.delete("N_DELETE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int n_update(NewsVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		int flag = sqlSession.update("N_UPDATE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int n_getTotalRows() {
		log.info("getTotalRows()....");

		int total_rows = sqlSession.selectOne("N_TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public int n_getSearchTotalRows(String searchKey, String searchWord) {
		log.info("getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("N_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			total_rows = sqlSession.selectOne("N_SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

}
