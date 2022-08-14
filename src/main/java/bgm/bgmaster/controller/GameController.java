package bgm.bgmaster.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bgm.bgmaster.domain.GameDTO;
import bgm.bgmaster.service.GameService;

@Controller
@RequestMapping("/game/*")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	//----------------updown게임 페이지 이동_GET -----------------------
	@GetMapping(value="/updown")
	public void getUpdown(Model model, HttpSession session) throws Exception{
		//logger.info("session.getAttribute(userid):{}",session.getAttribute("userid"));
		model.addAttribute("userid", session.getAttribute("userid"));
		
	}
	
	//#220728
	//----------------updown게임_POST----------------
	@ResponseBody
	@PostMapping(value="/updown")
	//public String postUpdown(GameDTO gameDTO, HttpSession session) throws Exception{
	public List<GameDTO> postUpdown(GameDTO gameDTO, HttpSession session) throws Exception {

		//logger.info("updown게임_POST 진입");
		//logger.info("recordTime:{}",gameDTO.getRecordTime());
		//logger.info("recordCount:{}",gameDTO.getRecordCount());
		
		String userid= (String)session.getAttribute("userid");
		//logger.info("userid:{}",userid);
		gameDTO.setUserid(userid);
		
		//updown -> gamecode:1
		gameDTO.setGame_code("1");
		
		gameService.postUpdown(gameDTO);

		//220811  슬
		// --------게임 상위 랭킹 보기--------		
		logger.info("랭킹 - updown게임_POST controller 진입");
		List<GameDTO> rankingUD = gameService.postUpdownRK();
		logger.info("rankingUD : {}", rankingUD);
//		return "";
		return rankingUD;
	
	}
	
	//#220728 슬
	//----------------가위바위보 게임 페이지 이동_GET -----------------------
	@GetMapping(value="/RPS")
	public void getRPS(Model model, HttpSession session,GameDTO gameDTO) throws Exception{
		model.addAttribute("userid", session.getAttribute("userid"));

		//220811 
		// --------가위바위보 아이디 별 기록 보기--------	
		String userid = (String) session.getAttribute("userid");
		gameDTO.setUserid(userid);
		
		HashMap<String, String> map = gameService.getRPS(userid);
		//도와줘!
		//List<Map<String, Object>> map = gameService.getRPS(userid);
		
		model.addAttribute("map",map);
		
		logger.info("list<map> : {}" , map);
		
		List<Map.Entry<String, String>> mapEntry = map.entrySet().stream().collect(Collectors.toList());
		
	}
	

	//----------------가위바위보 게임_POST----------------
	@ResponseBody
	@PostMapping(value="/RPS")
	public String postRPS(GameDTO gameDTO, Model model, HttpSession session) throws Exception{
		
		//logger.info("가위바위보 게임_POST 진입");
		//logger.info("winorlose:{}",gameDTO.getWinorlose());
		
		String userid= (String)session.getAttribute("userid");
		//logger.info("userid:{}",userid);
		gameDTO.setUserid(userid);
		
		// 2200730_kyu
		model.addAttribute("userid",userid);
		//가위바위보 -> gamecode:2
		gameDTO.setGame_code("2");
		
		gameService.postRPS(gameDTO);
		
		return "";
	}
}
