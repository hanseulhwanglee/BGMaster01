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
	
	
	//-------기록 저장-----
	@Override
	public void postRecord(RecordDTO recordDTO) throws Exception {
		sql.insert(NAMESPACE+".recordInsert",recordDTO);
	}

}
