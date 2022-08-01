package bgm.bgmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.dao.GameDAO;
import bgm.bgmaster.domain.GameDTO;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;
	
	//-----updown 기록저장-----
	@Override
	public void postUpdown(GameDTO gameDTO) throws Exception {
		gameDAO.postUpdown(gameDTO);
	}
	
	//-----가위바위보 기록저장-----
	@Override
	public void postRPS(GameDTO gameDTO)throws Exception{
		gameDAO.postRPS(gameDTO);
	}

}
