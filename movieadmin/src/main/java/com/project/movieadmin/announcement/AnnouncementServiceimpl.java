package com.project.movieadmin.announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnouncementServiceimpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDAO dao;
	
	@Override
	public int a_insert(AnnouncementVO vo) {
		
		return dao.a_insert(vo);
	}

	@Override
	public int a_update(AnnouncementVO vo) {
		
		return dao.a_update(vo);
	}

	@Override
	public int a_delete(AnnouncementVO vo) {
		
		return dao.a_delete(vo);
	}

	@Override
	public AnnouncementVO a_selectOne(AnnouncementVO vo) {
		
		return dao.a_selectOne(vo);
	}

	@Override
	public List<AnnouncementVO> a_selectAll(int cpage, int pageBlock) {
		
		return dao.a_selectAll(cpage, pageBlock);
	}

	@Override
	public List<AnnouncementVO> a_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		
		return dao.a_searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int a_getTotalRows() {
		
		return dao.a_getTotalRows();
	}

	@Override
	public int a_getSearchTotalRows(String searchKey, String searchWord) {
		
		return dao.a_getSearchTotalRows(searchKey, searchWord);
	}

	@Override
	public List<AnnouncementVO> a_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		
		return dao.a_selectAll_nickname(cpage, pageBlock, vo);
	}

	@Override
	public List<AnnouncementVO> a_selectAll() {
		
		return dao.a_selectAll();
	}

}
