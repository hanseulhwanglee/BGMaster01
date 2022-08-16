package bgm.bgmaster.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.controller.RecordController;
import bgm.bgmaster.domain.RecordDTO;

@Repository
public class RecordDAOImpl implements RecordDAO {

	@Autowired
	private SqlSession sql;
	
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

	private static final String NAMESPACE = "BGMaster.recordMapper";
	
	
	//-----기록 전체 호출-----
	@Override
	public List<RecordDTO> getRecord() throws Exception{
		return sql.selectList(NAMESPACE+".whole_list");
	}

	//0805
	//-----Game_Code 리스트 호출-----
	public List<RecordDTO> getCode(String code) throws Exception{
		return sql.selectList(NAMESPACE+".code_list",code);
	}
	
	//0808
	//-----기록 리스트 호출 ajax-----
	public List<RecordDTO> getRecord2(RecordDTO gamecode) throws Exception{
		logger.info("ajax record2 DAO 진입");
		return sql.selectList(NAMESPACE+".code_list_ajax",gamecode);
	}
	
	
}
