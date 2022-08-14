package bgm.bgmaster.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.controller.GameController;

import bgm.bgmaster.domain.GameDTO;

@Repository
public class GameDAOImpl implements GameDAO {

	@Autowired
	private SqlSession sql;
	private static final Logger logger = LoggerFactory.getLogger(GameDAOImpl.class);


	private static final String NAMESPACE = "BGMaster.gameMapper";
	
	
	//-----updown 기록저장-----
	@Override
	public void postUpdown(GameDTO gameDTO) throws Exception {
		sql.insert(NAMESPACE+".recordInsertUD",gameDTO);
	}
	
	//-----가위바위보 기록저장-----
	@Override
	public void postRPS(GameDTO gameDTO)throws Exception{
		sql.insert(NAMESPACE+".recordInsertRPS",gameDTO);
	}
	

	//-----updown 상위 랭킹 보기-----
	@Override
	public List<GameDTO> postUpdownRK() throws Exception{
		//logger.info("랭킹 - updown게임_POST DAO  진입");
		return sql.selectList(NAMESPACE+".ranking_UD");
	}
	
	// --------가위바위보 아이디 별 기록 보기--------	
	@Override
	public HashMap<String, String> getRPS(String userid) throws Exception{ //
	//도와줘!	
	//public List<Map<String, Object>> getRPS(String userid) throws Exception{
		logger.info("가위바위보 Hashmap DAO 진입");
		//List<Map<String, Object>> test =  sql.selectOne(NAMESPACE+".sum_record_RPS",userid);
		logger.info("가위바위보 Hashmap DAO 진입-test");
		return sql.selectOne(NAMESPACE+".sum_record_RPS",userid);
		//return test;
		

	}

}
