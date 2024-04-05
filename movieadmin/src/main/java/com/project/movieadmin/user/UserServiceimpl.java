package com.project.movieadmin.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceimpl implements UserService {@Override
	public int u_insert(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int u_update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int u_delete(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO u_selectOne(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO u_login(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> u_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> u_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int u_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int u_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
