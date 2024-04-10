package com.project.movieadmin.info;

import java.util.Date;
import java.util.List;

public interface InfoDAO {
	
	public InfoDAO i_selectOne(InfoVO vo);
	public List<InfoDAO> i_selectAll(int cpage, int pageBlock);
	public List<InfoDAO> i_searchList(String searchKey, String searchWord, int cpage, int pageBlock);
	public int i_getTotalRows();
	public int i_getSearchTotalRows(String searchKey, String searchWord);
	public int i_increaseRecommends(InfoVO vo);
	
	//public List<InfoDAO> sortRecommends(int recommends, int cpage, int pageBlock);
	//public List<InfoDAO> sortDate(Date relaseDate, int cpage, int pageBlock);

}