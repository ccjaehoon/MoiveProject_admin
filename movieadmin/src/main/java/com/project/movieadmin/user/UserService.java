package com.project.movieadmin.user;

import java.util.List;



public interface UserService {
	
	public int u_insert(UserVO vo);

	public int u_update(UserVO vo);

	public int u_delete(UserVO vo);

	public UserVO u_selectOne(UserVO vo);

	public UserVO u_login(UserVO vo);

	public List<UserVO> u_selectAll(int cpage, int pageBlock);

	public List<UserVO> u_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int u_getTotalRows();

	public int u_getSearchTotalRows(String searchKey, String searchWord);

	public UserVO u_idCheck(UserVO vo);
	
	public UserVO u_nicknameCheck(UserVO vo);
	
	public UserVO u_emailCheck(UserVO vo);

	public UserVO u_loginCheck(UserVO vo);

	public UserVO u_selectOne_id(UserVO vo);

	

	
}
