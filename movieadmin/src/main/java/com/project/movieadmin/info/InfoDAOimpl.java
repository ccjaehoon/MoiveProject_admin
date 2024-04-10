package com.project.movieadmin.info;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class InfoDAOimpl implements InfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
<<<<<<< HEAD
	
	public InfoDAOimpl() {
		log.info("InfoDAOimpl()....");
	}

	@Override
	public InfoDAO i_selectOne(InfoVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		NewsVO vo2 = sqlSession.selectOne("N_SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<InfoDAO> i_selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		
		log.info("startRow:{}",startRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow-1);
		map.put("pageBlock", pageBlock);

		List<InfoVO> vos = sqlSession.selectList("N_SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public List<InfoDAO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....");
		log.info(searchKey);
		log.info(searchWord);

		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		log.info("startRow:{}",startRow);

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow-1);

		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<NewsVO> vos = null;

		if (searchKey.equals(" ")) {
			vos = sqlSession.selectList("I_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals(" ")) {
			vos = sqlSession.selectList("I_SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		}

		return vos;
=======

	@Override
	public InfoDAO i_selectOne(InfoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoDAO> i_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoDAO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> branch 'main' of https://github.com/ccjaehoon/MoiveProject_admin.git
	}

	@Override
	public int i_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int i_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int i_increaseRecommends(InfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
