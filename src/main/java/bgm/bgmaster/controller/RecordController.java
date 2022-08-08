package bgm.bgmaster.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bgm.bgmaster.domain.RecordDTO;
import bgm.bgmaster.service.RecordService;


@Controller
@RequestMapping("/record/*")
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	//0803
//	private RecordMapper recordMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

	//==============Record.jsp==============
	// #220731 슬
	// ----------------게임 결과 통계 페이지 이동_GET Record-----------------------
	@GetMapping(value = "/record")
	public void getRecord(Model model, HttpSession session) throws Exception {
		model.addAttribute("userid", session.getAttribute("userid")); // login_message userid

		List<RecordDTO> record = recordService.getRecord();
		model.addAttribute("record", record);
	}

	// ----------------게임 결과 통계_POST -----------------------
	@ResponseBody
	@RequestMapping(value="/record", method = {RequestMethod.POST}) 
	public String postRecord(RecordDTO recordDTO, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		return ""; 
	}
	
	//==============gameCode.jsp==============
	// #220804 슬
	// ----------------game_code별 List 페이지 이동_GET -----------------------
	@GetMapping(value = "/gameCode")
	public void getCode(Model model, HttpSession session, @RequestParam("game_code") String code, HttpServletRequest request) throws Exception {
		model.addAttribute("userid", session.getAttribute("userid")); // login_message userid

		//List<RecordDTO> record = recordService.getCode1();
		List<RecordDTO> record = recordService.getCode(code);
		model.addAttribute("record", record);
		logger.info("RequestParam : {} " , code);
	}
	
	
	//==============Record2.jsp==============
	// #220807 슬
	// ----------------게임 결과 통계 페이지 이동_GET Record2-----------------------
	@GetMapping(value = "/record2")
	public void getRecord2(Model model, HttpSession session) throws Exception{
		model.addAttribute("userid", session.getAttribute("userid")); // login_message userid
	}
	
	// 220808 
	// ----------------게임 결과 통계 AJAX_POST Record2-----------------------
	@ResponseBody
	@RequestMapping(value="/record2", method = {RequestMethod.POST}) 
	public String postRecord2(Model model, HttpServletRequest request) throws Exception{
		String gamecode = request.getParameter("gamecode");
		logger.info("gamecode_post2_ajax:{}", gamecode);
		
		logger.info("ajax record2 controller 진입");
		
		List<RecordDTO> record2 = recordService.getRecord2(gamecode);
		model.addAttribute("record2", record2);
	
	return ""; 
	
	}
	

}
