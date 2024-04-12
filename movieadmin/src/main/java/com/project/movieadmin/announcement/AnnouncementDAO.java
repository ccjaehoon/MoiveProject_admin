package com.project.movieadmin.announcement;

import java.util.List;

import com.project.movieadmin.user.UserVO;

public interface AnnouncementDAO {
	
	public int a_insert(AnnouncementVO vo);

	public int a_update(AnnouncementVO vo);

	public int a_delete(AnnouncementVO vo);
	
	public AnnouncementVO a_selectOne(AnnouncementVO vo);

	public List<AnnouncementVO> a_selectAll(int cpage, int pageBlock);

	public List<AnnouncementVO> a_searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int a_getTotalRows();

	public int a_getSearchTotalRows(String searchKey, String searchWord);

	public List<AnnouncementVO> a_selectAll_nickname(int cpage, int pageBlock, UserVO vo);



}
