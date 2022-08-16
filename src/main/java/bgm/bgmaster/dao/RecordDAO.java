package bgm.bgmaster.dao;

import java.util.List;

import bgm.bgmaster.domain.RecordDTO;

public interface RecordDAO {

	//-----기록 전체 호출-----
	public List<RecordDTO> getRecord() throws Exception;
	
	//0803 mapper interface

	//0805
	//-----Game_Code 리스트 호출-----
	public List<RecordDTO> getCode(String code) throws Exception;
	
	//0808
	//-----기록 리스트 호출 ajax-----
	public List<RecordDTO> getRecord2(RecordDTO gamecode) throws Exception;
}
