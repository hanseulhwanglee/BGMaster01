package bgm.bgmaster.dao;

import bgm.bgmaster.domain.RecordDTO;

public interface RecordDAO {

	//-----updown 기록저장-----
	public void postRecord(RecordDTO recordDTO)throws Exception;
}
