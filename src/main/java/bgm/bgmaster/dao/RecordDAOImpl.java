package bgm.bgmaster.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.domain.MemberDTO;
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
	@Override
	public List<RecordDTO> getCode(String code) throws Exception{
		return sql.selectList(NAMESPACE+".code_list",code);
	}
	
	//0808
	//-----기록 리스트 호출 ajax-----
	@Override
	public List<RecordDTO> getRecord2(RecordDTO gamecode) throws Exception{
		logger.info("ajax record2 DAO 진입");
		return sql.selectList(NAMESPACE+".code_list_ajax",gamecode);
	}
	
	//0818 
	//-----Record3 Game_code & month-----
	@Override
	public List<RecordDTO> postRecord3(RecordDTO recordDTO) throws Exception{
		return sql.selectList(NAMESPACE+".code_month_list", recordDTO);
	}
	
	//0818 
	//-----Record3 Connect_time Date-----
	@Override
	public List<RecordDTO> postRecord3_2(String date) throws Exception{
		Map<String, Integer> dateMap = new HashMap<String,Integer>();
		int year = Integer.parseInt(date.substring(0,4));
		int month = Integer.parseInt(date.substring(5,7));
		int day = Integer.parseInt(date.substring(8,10));
		dateMap.put("year", year);
		dateMap.put("month", month);
		dateMap.put("day", day);
		return sql.selectList(NAMESPACE+".selected_date", dateMap);
	}
	
	//0824
	//-----Record4 Record_time & Birthday-----
	@Override
	public List<MemberDTO> postRecord4_1() throws Exception{
		return sql.selectList(NAMESPACE+".birthday_code1");
	}
	
	//0831
	//-----Record4 승률 & Birthday-----
	@Override
	public List<MemberDTO> postRecord4_2() throws Exception{
		return sql.selectList(NAMESPACE+".birthday_code2");
	}
}
