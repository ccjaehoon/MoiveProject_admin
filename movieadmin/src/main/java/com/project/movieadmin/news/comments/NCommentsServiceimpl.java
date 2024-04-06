package com.project.movieadmin.news.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.news.NewsDAO;

@Service
public class NCommentsServiceimpl implements NCommentsService {

	@Autowired
	private NCommentsDAO dao;
	
	@Override
	public int insert(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NCommentsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nc_increaseGood(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nc_increaseReport(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
