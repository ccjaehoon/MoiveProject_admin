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
	public int nc_insert(NCommentsVO vo) {
		return dao.nc_insert(vo);
	}

	@Override
	public int nc_update(NCommentsVO vo) {
		// TODO Auto-generated method stub
		return dao.nc_update(vo);
	}

	@Override
	public int nc_delete(NCommentsVO vo) {
		return dao.nc_delete(vo);
	}

	@Override
	public List<NCommentsVO> nc_selectAll(NCommentsVO vo) {
		return dao.nc_selectAll(vo);
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
