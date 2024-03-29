package bgm.bgmaster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bgm.bgmaster.domain.GameDTO;

public interface GameService {

	//-----updown 기록저장-----
	public void postUpdown(GameDTO gameDTO) throws Exception;
	
	//-----가위바위보 기록저장-----
	public void postRPS(GameDTO gameDTO)throws Exception;

	//-----updown 상위 랭킹 보기-----
	public List<GameDTO> postUpdownRK() throws Exception;
	
	// --------가위바위보 아이디 별 기록 보기--------	
	public List<Map<String, Object>> getRPS(String userid) throws Exception;

}
