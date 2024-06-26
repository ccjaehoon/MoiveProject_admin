package com.project.movieadmin.news.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieadmin.news.NewsDAO;
import com.project.movieadmin.user.UserVO;

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
		return dao.nc_increaseGood(vo);
	}
	
	@Override
	public NCommentsVO nc_selectGood(NCommentsVO vo) {
		return dao.nc_selectGood(vo);
	}

	@Override
	public int nc_goodCheck(NCommentsVO vo) {
		return dao.nc_goodCheck(vo);
	}

	@Override
	public int nc_goodSave(NCommentsVO vo) {
		return dao.nc_goodSave(vo);
	}

	@Override
	public List<NCommentsVO> nc_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		return dao.nc_selectAll_nickname(cpage, pageBlock, vo);
	}

	

}
