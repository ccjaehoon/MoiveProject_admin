package com.project.movieadmin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceimpl implements UserService {
	
	
	
	@Autowired
	private UserDAO dao;

	@Override
	public int u_insert(UserVO vo) {
		
		return dao.u_insert(vo);
	}

	@Override
	public int u_update(UserVO vo) {
		
		return dao.u_update(vo);
	}

	@Override
	public int u_delete(UserVO vo) {
		
		return dao.u_delete(vo);
	}

	@Override
	public UserVO u_selectOne(UserVO vo) {
		
		return dao.u_selectOne(vo);
	}



	@Override
	public List<UserVO> u_selectAll(int cpage, int pageBlock) {
		
		return dao.u_selectAll(cpage, pageBlock);
	}

	@Override
	public List<UserVO> u_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		
		return dao.u_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int u_getTotalRows() {
		
		return dao.u_getTotalRows();
	}

	@Override
	public int u_getSearchTotalRows(String searchKey, String searchWord) {
		
		return dao.u_getSearchTotalRows(searchKey, searchWord);
	}
	@Override
	public UserVO u_login(UserVO vo) {
		
		return dao.u_login(vo);
	}

	@Override
	public UserVO u_idCheck(UserVO vo) {
		
		return dao.u_idCheck(vo);
	}

	@Override
	public UserVO u_nicknameCheck(UserVO vo) {
		
		return dao.u_nicknameCheck(vo);
	}

	@Override
	public UserVO u_emailCheck(UserVO vo) {
		
		return dao.u_emailCheck(vo);
	}

	@Override
	public UserVO u_loginCheck(UserVO vo) {
		
		return dao.u_loginCheck(vo);
	}

	@Override
	public UserVO u_selectOne_id(UserVO vo) {
		
		return dao.u_selectOne_id(vo);
	}

	@Override
	public int findPwCheck(UserVO vo) {
		return dao.findPwCheck(vo);
	}

	@Override
	public UserVO findPw(UserVO vo) {
		return dao.findPw(vo);
	}


	
}
