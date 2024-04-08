package com.project.movieadmin.news;

import java.util.List;

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
		return null;
	}

	@Override
	public NewsVO n_selectOne(NewsVO vo) {
		return null;
	}

	@Override
	public List<NewsVO> n_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		return null;
	}

	@Override
	public int n_insert(NewsVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int n_delete(NewsVO vo) {
		return 0;
	}

	@Override
	public List<NewsVO> n_update(NewsVO vo) {
		return null;
	}

	@Override
	public int n_getTotalRows() {
		return 0;
	}

	@Override
	public int n_getSearchTotalRows(String searchKey, String searchWord) {
		return 0;
	}

}
