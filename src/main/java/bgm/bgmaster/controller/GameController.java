package bgm.bgmaster.controller;

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

import bgm.bgmaster.domain.RecordDTO;
import bgm.bgmaster.service.RecordService;

@Controller
@RequestMapping("/game/*")
public class GameController {
	
	@Autowired
	private RecordService recordService;
	
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
	public String postUpdown(RecordDTO recordDTO, HttpSession session/*, @RequestParam(name ="recordCount") String a, @RequestParam(name ="recordTime") String b */) throws Exception{
		
		//logger.info("updown게임_POST 진입");
		//logger.info("recordTime:{}",recordDTO.getRecordTime());
		//logger.info("recordCount:{}",recordDTO.getRecordCount());
		
		String userid= (String)session.getAttribute("userid");
		//logger.info("userid:{}",userid);
		recordDTO.setUserid(userid);
		
		//updown -> gamecode:1
		recordDTO.setGame_code("1");
		
		recordService.postUpdown(recordDTO);
		
		return "";
	}
	
	//#220728 슬
	//----------------가위바위보 게임 페이지 이동_GET -----------------------
	@GetMapping(value="/RPS")
	public void getRPS(Model model, HttpSession session) throws Exception{
		//logger.info("session.getAttribute(userid):{}",session.getAttribute("userid"));
		model.addAttribute("userid", session.getAttribute("userid"));
		
	}
	

	//----------------가위바위보 게임_POST----------------
	@ResponseBody
	@PostMapping(value="/RPS")
	public String postRPS(RecordDTO recordDTO, Model model, HttpSession session) throws Exception{
		
		//logger.info("가위바위보 게임_POST 진입");
		//logger.info("winorlose:{}",recordDTO.getWinorlose());
		
		String userid= (String)session.getAttribute("userid");
		//logger.info("userid:{}",userid);
		recordDTO.setUserid(userid);
		
		// 2200730_kyu
		model.addAttribute("userid",userid);
		//가위바위보 -> gamecode:2
		recordDTO.setGame_code("2");
		
		recordService.postRPS(recordDTO);
		
		return "";
	}
}
