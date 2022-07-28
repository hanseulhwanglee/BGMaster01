package bgm.bgmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.dao.RecordDAO;
import bgm.bgmaster.domain.RecordDTO;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;
	
	//-----updown 기록저장-----
	@Override
	public void postUpdown(RecordDTO recordDTO) throws Exception {
		recordDAO.postUpdown(recordDTO);
	}
	
	//-----가위바위보 기록저장-----
	@Override
	public void postRPS(RecordDTO recordDTO)throws Exception{
		recordDAO.postRPS(recordDTO);
	}

}
