package bgm.bgmaster.service;

import org.springframework.stereotype.Service;

import bgm.bgmaster.domain.RecordDTO;

public interface RecordService {

	//-----updown 기록저장-----
	public void postUpdown(RecordDTO recordDTO) throws Exception;
	
	//-----가위바위보 기록저장-----
	public void postRPS(RecordDTO recordDTO)throws Exception;
}
