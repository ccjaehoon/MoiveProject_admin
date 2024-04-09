package com.project.movieadmin.faq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FaqDAOimpl implements FaqDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int f_insert(FaqVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("F_INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int f_update(FaqVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		int flag = sqlSession.update("F_UPDATE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int f_delete(FaqVO vo) {
		int flag = sqlSession.insert("F_DELETE", vo);

		return flag;
	}

	@Override
	public FaqVO f_selectOne(FaqVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		FaqVO vo2 = sqlSession.selectOne("F_SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<FaqVO> f_selectAll(int cpage, int pageBlock) {
		int startRow = (cpage - 1) * pageBlock + 1;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startRow", startRow - 1);
        map.put("pageBlock", pageBlock);

        List<FaqVO> vos = sqlSession.selectList("F_SELECT_ALL_PAGE_BLOCK", map);
        return vos;
	}

	@Override
	public List<FaqVO> f_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....");
		log.info(searchKey);
		log.info(searchWord);

		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		log.info("startRow:{}", startRow);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<FaqVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("F_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("content")) {
			vos = sqlSession.selectList("F_SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		}

		return vos;
	}

	@Override
	public int f_getTotalRows() {
		int total_rows = sqlSession.selectOne("F_TOTAL_ROWS");
		return total_rows;
	}

	@Override
	public int f_getSearchTotalRows(String searchKey, String searchWord) {
		log.info("f_getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("F_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			total_rows = sqlSession.selectOne("F_SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

}
