package bgm.bgmaster.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.domain.RecordDTO;

@Repository
public class RecordDAOImpl implements RecordDAO {

	@Autowired
	private SqlSession sql;

	private static final String NAMESPACE = "BGMaster.gameMapper";
	
	
	//-----updown 기록저장-----
	@Override
	public void postUpdown(RecordDTO recordDTO) throws Exception {
		sql.insert(NAMESPACE+".recordInsertUD",recordDTO);
	}
	
	//-----가위바위보 기록저장-----
	@Override
	public void postRPS(RecordDTO recordDTO)throws Exception{
		sql.insert(NAMESPACE+".recordInsertRPS",recordDTO);
	}

}
