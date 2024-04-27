package com.project.movieadmin.story;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.project.movieadmin.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StoryDAOimpl implements StoryDAO {
	
	@Autowired
	private SqlSession sqlSession; //전역변수
	
	public StoryDAOimpl() { //생성자 (이 안에서 정의한 변수는 로컬변수)
		log.info("StoryDAOimpl()....");
	}
	
	
	@Override
	public int s_insert(StoryVO vo) {
		log.info("s_insert()....");
		log.info(vo.toString());

		return sqlSession.insert("S_INSERT", vo);
	}

	@Override
	public int s_update(StoryVO vo) {
		log.info("s_update()....");
		log.info(vo.toString());

		return sqlSession.update("S_UPDATE", vo);
	}

	@Override
	public int s_delete(StoryVO vo) {
		log.info("s_delete()....");
		log.info(vo.toString());

		return sqlSession.delete("S_DELETE", vo);
	}
	
	@Override
	public StoryVO s_selectOne(StoryVO vo) {
		log.info("s_selectOne()....");
		log.info(vo.toString());

		return sqlSession.selectOne("S_SELECT_ONE", vo);
						//쿼리 결과가 단 하나의 값만을 가질 것으로 예상될 때 사용
	}
	
	@Override
	public StoryVO s_selectRandomList(StoryVO vo) {
		log.info("s_selectRandomList()....");
		log.info(vo.toString());

		return sqlSession.selectOne("S_SELECT_RANDOMLIST", vo);
	}

	@Override
	public List<StoryVO> s_selectAll() {
		log.info("s_selectAll()...");

		return sqlSession.selectList("S_SELECT_ALL");
	}

	@Override
	public List<StoryVO> s_selectAll(int cpage, int pageBlock) {
		log.info("s_selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		return sqlSession.selectList("S_SELECT_ALL_PAGE_BLOCK", map);
						// 페이징 처리를 위해 여러 개의 레코드를 한 번에 가져올때 사용
	}
	
	@Override
	public int s_getTotalRows() {
		log.info("getTotalRows()....");

		return sqlSession.selectOne("S_TOTAL_ROWS");
	}


	@Override
	public List<StoryVO> s_getLiveStories() {
	    log.info("getLiveStories...."); // 데이터베이스에서 만료되지 않은 스토리를 조회하는 쿼리 실행
	    
	    return sqlSession.selectList("S_GETLIVESTORIES");
	}

	@Override
	public int s_increaseGood(StoryVO vo) {
		log.info("s_increaseGood()....");
		log.info("vo:{}",vo);
		int count = sqlSession.selectOne("S_SELECT_GOOD", vo);
		log.info("count:{}",count);
		if(count==0) {
			sqlSession.insert("S_INSERT_GOOD", vo);
			int result = sqlSession.selectOne("S_CHECK_USER_GOOD_COUNT", vo);
			log.info("result:{}",result);
			return result;
		}else {
			return 0;
		}
	}
	
	@Override
	public StoryVO s_selectGood(StoryVO vo) {
		log.info("s_selectGood()....");
		log.info(vo.toString());
		return sqlSession.selectOne("S_SELECT_GOOD", vo);
	}

	@Override
	public int s_goodCheck(StoryVO vo) {
		return sqlSession.selectOne("S_GOOD_CHECK", vo);
	}

	@Override
	public int s_goodSave(StoryVO vo) {
		return sqlSession.insert("S_GOOD_SAVE", vo);
	}
	

	@Override
	public int s_increaseReport(StoryVO vo) {
		log.info("s_increaseReport()....");
		// 해당 게시물의 신고수를 가져와 1 증가시킴
	    int currentReportCount = vo.getReport();
	    vo.setReport(currentReportCount + 1);

	    // 데이터베이스에 업데이트
	    return sqlSession.update("S_UPDATE_REPORT_COUNT", vo);
	}

	@Override
	public List<StoryVO> s_selectAll_nickname(int cpage, int pageBlock, UserVO vo) {
		log.info("s_selectAll_nick()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);
		map.put("pageBlock", pageBlock);
		map.put("vo", vo);

		return sqlSession.selectList("S_SELECT_ALL_PAGE_BLOCK_NICKNAME", map);
	}


}
