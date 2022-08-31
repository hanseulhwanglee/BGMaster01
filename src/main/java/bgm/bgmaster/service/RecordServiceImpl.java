package bgm.bgmaster.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.domain.MemberDTO;
import bgm.bgmaster.controller.RecordController;
import bgm.bgmaster.dao.RecordDAO;
import bgm.bgmaster.domain.RecordDTO;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;

	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
	
	//-----기록 전체 호출-----
	@Override
	public List<RecordDTO> getRecord() throws Exception{
		return recordDAO.getRecord();
	}

	//0805
	//-----Game_Code1 리스트 호출-----
	@Override
	public List<RecordDTO> getCode(String code) throws Exception{
		return recordDAO.getCode(code);
	}
	
	//0808
	//-----기록 리스트 호출 ajax-----
	@Override
	public List<RecordDTO> getRecord2(RecordDTO gamecode) throws Exception{
		logger.info("ajax record2 service 진입");
		
		return recordDAO.getRecord2(gamecode);
	}

	//0818
	//-----Record3 Game_code & month-----
	@Override
	public List<RecordDTO> postRecord3(RecordDTO recordDTO) throws Exception{
		return recordDAO.postRecord3(recordDTO);
	}
	
	//0818
	//-----Record3 Connect_time Date-----
	@Override
	public List<RecordDTO> postRecord3_2(String date) throws Exception{
		return recordDAO.postRecord3_2(date);
	}
	
	//-----Record4 Record_time & Birthday-----
	@Override
	public List<MemberDTO> postRecord4_1() throws Exception{
		return recordDAO.postRecord4_1();
	}
	
	//0831
	//-----Record4 승률 & Birthday-----
	@Override
	public List<MemberDTO> postRecord4_2() throws Exception{
		return recordDAO.postRecord4_2();
	}
}
