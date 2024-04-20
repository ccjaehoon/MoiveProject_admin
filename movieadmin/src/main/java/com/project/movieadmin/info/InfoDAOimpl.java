package com.project.movieadmin.info;

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
public class InfoDAOimpl implements InfoDAO {
	
	@Autowired
	private SqlSession sqlSession;

	
	public InfoDAOimpl() {
		log.info("InfoDAOimpl()....");
	}
	
	
	@Override
	public int i_insert(InfoVO vo) {
		log.info("insert()....");
		log.info(vo.toString());
		
		int flag = sqlSession.insert("I_INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}
	

	@Override
	public InfoVO i_selectOne(InfoVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());


		InfoVO vo2 = sqlSession.selectOne("I_SELECT_ONE", vo);


		return vo2;
	}

	@Override
	public List<InfoVO> i_selectAll(int cpage, int pageBlock) {
		log.info("i_selectAll()....");
		Map<String, Integer> map = new HashMap<String, Integer>();
	
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		
		log.info("startRow:{}",startRow);

		
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);
		List<InfoVO> vos = sqlSession.selectList("I_SELECT_ALL_PAGE_BLOCK", map);
	
		return vos;
	}

	@Override
	public List<InfoVO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {

		log.info("i_searchList()....");
		log.info(searchKey);
		log.info(searchWord);

		int startRow = (cpage - 1) * pageBlock + 1;
		log.info("startRow:{}",startRow);

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);

		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<InfoVO> vos = null;

		if (searchKey.equals("TITLE")) {
			vos = sqlSession.selectList("I_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("GENRE")) {
			vos = sqlSession.selectList("I_SEARCHLIST_PAGE_BLOCK_GENRE", map);
		} else if (searchKey.equals("ACTOR")) {
			vos = sqlSession.selectList("I_SEARCHLIST_PAGE_BLOCK_ACTOR", map);
		}
	

		return vos;
	}

	@Override
	public int i_getTotalRows() {
		log.info("i_getTotalRows()....");

		int total_rows = sqlSession.selectOne("I_TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public int i_getSearchTotalRows(String searchKey, String searchWord) {
		log.info("i_getSearchTotalRows()....");

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("I_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("genre")) {
			total_rows = sqlSession.selectOne("I_SEARCH_TOTAL_ROWS_GENRE", "%" + searchWord + "%");
		} else if (searchKey.equals("actor")) {
			total_rows = sqlSession.selectOne("I_SEARCH_TOTAL_ROWS_ACTOR", "%" + searchWord + "%");
		}

		return total_rows;
	}

	@Override
	public int i_increaseRecommends(InfoVO vo) {
		log.info("i_increaseGood()....");

		int total_rows = sqlSession.update("I_INCREASEGOOD", vo);

		return total_rows;
	}


	@Override
	public int i_favoriteCheck(InfoVO vo) {
		return sqlSession.selectOne("I_FAVORITE_CHECK", vo);
	}


	@Override
	public int i_favoriteSave(InfoVO vo) {
		return sqlSession.insert("I_FAVORITE_SAVE", vo);
	}


	@Override
	public int i_increaseViews(InfoVO vo) {
		log.info("i_increaseGood()....");
		log.info(vo.toString());
		return sqlSession.update("I_INCREASE_VIEWS", vo);
	}


	@Override
	public int i_getFavorite(InfoVO vo) {
		
		return sqlSession.insert("I_GET_FAVORITE", vo);
	}


	@Override
	public List<InfoVO> i_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		 int startRow = (cpage - 1) * pageBlock + 1;

	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("startRow", startRow - 1);
	        map.put("pageBlock", pageBlock);
	        map.put("nickname", vo.getNickname());
	        log.info("vo:{}",vo);
	        log.info("pageBlock{}",pageBlock);
	        log.info("nickname{}",vo.getNickname().length());
	        List<InfoVO> vos = sqlSession.selectList("I_SELECT_ALL_NICKNAME", map);
	        return vos;
	}

	
	
	
	
	//conflict 
}