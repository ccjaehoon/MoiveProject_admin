package com.project.movieadmin.info;

import java.util.List;

public interface InfoService {
	
	public InfoVO i_insert(InfoVO vo);
	public InfoVO i_selectOne(InfoVO vo);
	public List<InfoVO> i_selectAll(int cpage, int pageBlock);
	public List<InfoVO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock);
	public int i_getTotalRows();
	public int i_getSearchTotalRows(String searchKey, String searchWord);
	public int i_increaseRecommends(InfoVO vo);
	

}