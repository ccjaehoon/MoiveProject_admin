package com.project.movieadmin.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceimpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	public BoardServiceimpl() {
		log.info("BoardServiceimpl()...");
	}

	@Override
	public int b_insert(BoardVO vo) {

		return dao.b_insert(vo);
	}

	@Override
	public int b_update(BoardVO vo) {

		return dao.b_update(vo);
	}

	@Override
	public int b_delete(BoardVO vo) {

		return dao.b_delete(vo);
	}

	@Override
	public BoardVO b_selectOne(BoardVO vo) {

		return dao.b_selectOne(vo);
	}

	@Override
	public List<BoardVO> b_selectAll(int cpage, int pageBlock) {

		return dao.b_selectAll(cpage, pageBlock);
	}

	@Override
	public List<BoardVO> b_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {

		return dao.b_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int b_getTotalRows() {

		return dao.b_getTotalRows();
	}

	@Override
	public int b_getSearchTotalRows(String searchKey, String searchWord) {

		return dao.b_getSearchTotalRows(searchKey, searchWord);
	}
	
	@Override
	public List<BoardVO> b_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {

		return dao.b_selectAll_nickname(cpage, pageBlock, vo);
	}

	@Override
	public int b_increaseGood(BoardVO vo) {

		return dao.b_increaseGood(vo);
	}

	@Override
	public BoardVO b_selectGood(BoardVO vo) {
		return dao.b_selectGood(vo);
	}

	@Override
	public int b_goodCheck(BoardVO vo) {
		return dao.b_goodCheck(vo);
	}

	@Override
	public int b_goodSave(BoardVO vo) {
		return dao.b_goodSave(vo);
	}

	@Override
	public int b_increaseReport(BoardVO vo) {
		return dao.b_increaseReport(vo);
	}

	@Override
	public List<BoardVO> b_selectAll() {

		return dao.b_selectAll();
	}

}
