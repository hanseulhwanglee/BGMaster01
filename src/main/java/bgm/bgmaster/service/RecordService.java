package bgm.bgmaster.service;

import org.springframework.stereotype.Service;

import bgm.bgmaster.domain.RecordDTO;

public interface RecordService {

	//-----기록 저장----
	public void postRecord(RecordDTO recordDTO) throws Exception;
}
