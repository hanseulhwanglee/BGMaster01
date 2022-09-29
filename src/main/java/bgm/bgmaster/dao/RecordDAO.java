package bgm.bgmaster.dao;

import java.util.List;

import bgm.bgmaster.domain.MemberDTO;
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
	
	//0818
	//-----Record3 Game_code & month-----
	public List<RecordDTO> postRecord3(RecordDTO recordDTO) throws Exception;

	//0818
	//-----Record3 Connect_time Date-----
	public List<RecordDTO> postRecord3_2(String date) throws Exception;
	
	//0824
	//-----Record4 Record_time & Birthday-----
	public List<MemberDTO> postRecord4_1() throws Exception;
	
	//0831
	//-----Record4 승률 & Birthday-----
	public List<MemberDTO> postRecord4_2() throws Exception;
}
