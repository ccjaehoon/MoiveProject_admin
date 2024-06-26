package com.project.movieadmin.story.comments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieadmin.news.comments.NCommentsVO;
import com.project.movieadmin.story.StoryVO;
import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SCommentsDAOimpl implements SCommentsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public SCommentsDAOimpl() {
		log.info("SCommentsDAOimpl()....");
	}


	@Override
	public int sc_insert(SCommentsVO vo) {
		log.info("sc_insert()....");
		log.info(vo.toString());
		
		
		return sqlSession.insert("SC_INSERT", vo);
	}

	@Override
	public int sc_update(SCommentsVO vo) {
		log.info("sc_update()....");
		log.info(vo.toString());
		
		
		return sqlSession.update("SC_UPDATE", vo);
	}

	@Override
	public int sc_delete(SCommentsVO vo) {
		log.info("sc_delete()....");
		log.info(vo.toString());
		
		
		return sqlSession.delete("SC_DELETE", vo);
	}

	@Override
	public List<SCommentsVO> sc_selectAll() {
		log.info("sc_selectAll()....");
//		log.info(vo.toString());

		return sqlSession.selectList("SC_SELECT_ALL");
	}
	
	@Override
	public List<SCommentsVO> sc_selectAll(SCommentsVO vo) {
		log.info("sc_selectAll()....{}",vo);


        List<SCommentsVO> vos = sqlSession.selectList("SC_SELECT_ALL", vo);
        return vos;
	}

//	@Override
//	public List<SCommentsVO> sc_selectAll(int cpage, int pageBlock) {
//		System.out.println("sc_selectAll(page)....");
//		System.out.println("cpage:" + cpage);
//		System.out.println("pageBlock:" + pageBlock);
//		List<SCommentsVO> vos = new ArrayList<SCommentsVO>();
//		
//		return vos;
//	}
/**/
	@Override
	public int sc_increaseGood(SCommentsVO vo) {
		log.info("sc_increaseGood()....{}",vo);

		int count = sqlSession.selectOne("SC_SELECT_GOOD", vo);
		log.info("count:{}",count);
		if(count==0) {
			sqlSession.insert("SC_INSERT_GOOD", vo);
			sqlSession.update("SC_UPDATE_GOOD_COUNT", vo);
			int result =  sqlSession.selectOne("SC_SELECT_GOOD_COUNT", vo);
			log.info("result:{}",result);
			return result;
		}else {
			return 0;
		}
	}
	
	
	@Override
	public SCommentsVO sc_selectGood(SCommentsVO vo) {
		log.info("sc_selectGood()....");
		log.info(vo.toString());
		return sqlSession.selectOne("SC_SELECT_GOOD", vo);
	}

	@Override
	public int sc_goodCheck(SCommentsVO vo) {
		return sqlSession.selectOne("SC_GOOD_CHECK", vo);
	}

	@Override
	public int sc_goodSave(SCommentsVO vo) {
		return sqlSession.insert("SC_GOOD_SAVE", vo);
	}

	@Override
	public int sc_increaseReport(SCommentsVO vo) {
		log.info("sc_increaseReport()....");
		
		
		return 0;
	}


	@Override
	public List<SCommentsVO> sc_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		log.info("sc_selectAll_nick()....");
		int startRow = (cpage - 1) * pageBlock + 1;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", startRow - 1);
        map.put("pageBlock", pageBlock);
        map.put("vo", vo);

        List<SCommentsVO> vos = sqlSession.selectList("SC_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
        return vos;
	}

}
