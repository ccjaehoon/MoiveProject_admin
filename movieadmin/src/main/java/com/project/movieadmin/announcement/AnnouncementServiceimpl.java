package com.project.movieadmin.announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnouncementServiceimpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDAO dao;
	
	@Override
	public int a_insert(AnnouncementVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int a_update(AnnouncementVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int a_delete(AnnouncementVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnnouncementVO a_selectOne(AnnouncementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnouncementVO> a_selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnouncementVO> a_searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int a_getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int a_getSearchTotalRows(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
