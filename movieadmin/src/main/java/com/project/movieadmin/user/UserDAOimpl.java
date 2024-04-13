package com.project.movieadmin.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		int flag = sqlSession.insert("U_INSERT", vo);

		return flag;
	}

	@Override
	public int u_update(UserVO vo) {

		int flag = sqlSession.update("U_UPDATE", vo);

		return flag;
	}

	@Override
	public int u_delete(UserVO vo) {

		int flag = sqlSession.delete("U_DELETE", vo);

		return flag;
	}

	@Override
	public UserVO u_selectOne(UserVO vo) {
		log.info("{}", vo);
		UserVO vo2 = sqlSession.selectOne("U_SELECT_ONE", vo);

		return vo2;
	}

	

	@Override
	public List<UserVO> u_selectAll(int cpage, int pageBlock) {

		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);

		List<UserVO> vos = sqlSession.selectList("U_SELECT_ALL_PAGE_BLOCK", map);
		return vos;
	}

	@Override
	public List<UserVO> u_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {

		log.info("u_searchList");
		log.info("cpage : " + cpage);
		log.info("pageBlock : " + pageBlock);
		
		int startRow = (cpage - 1) * pageBlock + 1;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);
		map.put("searchWord",  "%" + searchWord + "%");
		
		List<UserVO> vos = null;

		if (searchKey.equals("user_id")) {
			vos = sqlSession.selectList("U_SEARCHLIST_PAGE_BLOCK_ID", map);
		} else if (searchKey.equals("nickname")) {
			vos = sqlSession.selectList("U_SEARCHLIST_PAGE_BLOCK_NICKNAME", map);
		}

		return vos;
	}

	@Override
	public int u_getTotalRows() {

		int total_rows = sqlSession.selectOne("U_TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public int u_getSearchTotalRows(String searchKey, String searchWord) {

		int total_rows = 0;

		if (searchKey.equals("user_id")) {
			total_rows = sqlSession.selectOne("U_SEARCH_TOTAL_ROWS_ID", "%" + searchWord + "%");
		} else if (searchKey.equals("nickname")) {
			total_rows = sqlSession.selectOne("U_SEARCH_TOTAL_ROWS_NICKNAME", "%" + searchWord + "%");
		}

		return total_rows;
	}
	@Override
	public UserVO u_login(UserVO vo) {

		UserVO vo2 = sqlSession.selectOne("U_LOGIN", vo);

		return vo2;
	}

	@Override
	public UserVO u_idCheck(UserVO vo) {

		return sqlSession.selectOne("U_ID_CHECK",vo);
	}

	@Override
	public UserVO u_nicknameCheck(UserVO vo) {

		return sqlSession.selectOne("U_NICKNAME_CHECK",vo);
	}

	@Override
	public UserVO u_emailCheck(UserVO vo) {

		return sqlSession.selectOne("U_EMAIL_CHECK",vo);
	}

	@Override
	public UserVO u_loginCheck(UserVO vo) {
		
		return sqlSession.selectOne("U_LOGIN_CHECK",vo);
	}

	@Override
	public UserVO u_selectOne_id(UserVO vo) {
		log.info("{}", vo);
		UserVO vo2 = sqlSession.selectOne("U_SELECT_ONE_ID", vo);

		return vo2;
	}
	


}
