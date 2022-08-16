package bgm.bgmaster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.controller.GameController;

import bgm.bgmaster.dao.GameDAO;
import bgm.bgmaster.domain.GameDTO;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;
	private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

	
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
	
	
	//-----updown 상위 랭킹 보기-----
	@Override
	public List<GameDTO> postUpdownRK() throws Exception{
		logger.info("랭킹 - updown게임_POST seivice  진입");

		return gameDAO.postUpdownRK();
	}
	
	// --------가위바위보 아이디 별 기록 보기--------	
	public List<Map<String, Object>> getRPS(String userid) throws Exception{
		logger.info("가위바위보 Hashmap Service 진입");
		return gameDAO.getRPS(userid);
	}

}
