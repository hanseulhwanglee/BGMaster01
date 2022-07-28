package bgm.bgmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.dao.RecordDAO;
import bgm.bgmaster.domain.RecordDTO;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;
	
	//---------기록 저장---------
	@Override
	public void postRecord(RecordDTO recordDTO) throws Exception {
		recordDAO.postRecord(recordDTO);
	}

}
