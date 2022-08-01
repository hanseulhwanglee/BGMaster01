package bgm.bgmaster.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.domain.GameDTO;

@Repository
public class GameDAOImpl implements GameDAO {

	@Autowired
	private SqlSession sql;

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

}
