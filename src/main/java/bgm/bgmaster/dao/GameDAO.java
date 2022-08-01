package bgm.bgmaster.dao;

import bgm.bgmaster.domain.GameDTO;

public interface GameDAO {

	//-----updown 기록저장-----
	public void postUpdown(GameDTO gameDTO)throws Exception;
	
	//-----가위바위보 기록저장-----
	public void postRPS(GameDTO gameDTO)throws Exception;
}
