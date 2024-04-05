package com.project.movieadmin.faq;

import java.util.List;

public interface FaqService {
	public int insert(FaqVO vo);

	public int update(FaqVO vo);

	public int delete(FaqVO vo);

	public FaqVO selectOne(FaqVO vo);

	public List<FaqVO> selectAll(int cpage,int pageBlock);

	public List<FaqVO> searchList(String searchKey, String searchWord,int cpage,int pageBlock);

	public int getTotalRows();
	public int getSearchTotalRows(String searchKey, String searchWord);
}
