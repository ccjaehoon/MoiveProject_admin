package com.project.movieadmin.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDAOimpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
		
	@Override
	public int u_insert(UserVO vo) {
		
	int flag = sqlSession.insert("INSERT", vo);

	return flag;
	}

	@Override
	public int u_update(UserVO vo) {
		
		int flag = sqlSession.insert("UPDATE", vo);

		return flag;
	}

	@Override
	public int u_delete(UserVO vo) {
		
		int flag = sqlSession.insert("DELETE", vo);

		return flag;
	}

	@Override
	public UserVO u_selectOne(UserVO vo) {
		
		return null;
	}

	@Override
	public UserVO u_login(UserVO vo) {
		
		return null;
	}

	@Override
	public List<UserVO> u_selectAll(int cpage, int pageBlock) {
		
		return null;
	}

	@Override
	public List<UserVO> u_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		
		return null;
	}

	@Override
	public int u_getTotalRows() {
		
		return 0;
	}

	@Override
	public int u_getSearchTotalRows(String searchKey, String searchWord) {
		
		return 0;
	}

	@Override
	public UserVO idCheck(UserVO vo) {
		
		return null;
	}

	@Override
	public UserVO nicknameCheck(UserVO vo) {
		
		return null;
	}

	@Override
	public UserVO emailCheck(UserVO vo) {
		
		return null;
	}

}
