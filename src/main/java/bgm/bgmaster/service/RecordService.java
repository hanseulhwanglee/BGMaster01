package bgm.bgmaster.service;

import java.util.List;

import bgm.bgmaster.domain.RecordDTO;

public interface RecordService {

	
	//-----기록 전체 호출-----
	public List<RecordDTO> getRecord() throws Exception;

	//0805
	//-----Game_Code1 리스트 호출-----
	public List<RecordDTO> getCode(String code) throws Exception;
	
	//0808
	//-----기록 리스트 호출 ajax-----
	public List<RecordDTO> getRecord2(RecordDTO gamecode) throws Exception;
}
