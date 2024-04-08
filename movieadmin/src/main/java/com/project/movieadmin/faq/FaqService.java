package com.project.movieadmin.faq;

import java.util.List;

public interface FaqService {
	public int f_insert(FaqVO vo);

	public int f_update(FaqVO vo);

	public int f_delete(FaqVO vo);

	public FaqVO f_selectOne(FaqVO vo);

	public List<FaqVO> f_selectAll(int cpage,int pageBlock);

	public List<FaqVO> f_searchList(String searchKey, String searchWord,int cpage,int pageBlock);

	public int f_getTotalRows();
	public int f_getSearchTotalRows(String searchKey, String searchWord);
}
