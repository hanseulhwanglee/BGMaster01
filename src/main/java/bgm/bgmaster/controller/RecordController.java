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

import bgm.bgmaster.domain.MemberDTO;
import bgm.bgmaster.domain.RecordDTO;
import bgm.bgmaster.service.RecordService;

 //test
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

	//test
	
	
	
	
	
	
	
	
	
	
	
	
	//test2
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
	public List<RecordDTO> postRecord2(Model model, HttpServletRequest request, RecordDTO dto) throws Exception{
		/*
		String gamecode = request.getParameter("gamecode");
		logger.info("gamecode_post2_ajax:{}", gamecode);
		logger.info("ajax record2 controller 진입");
		*/
		
		logger.info("dto:{}",dto);
		//List<RecordDTO> record2 = recordService.getRecord2(gamecode);
		//model.addAttribute("record2", record2);
		List<RecordDTO> record2 = recordService.getRecord2(dto);
		logger.info("record2:{}",record2);
	
	return record2; 
	
	}
	

	// #220818 슬
	// ----------------게임 결과 통계 페이지 이동_GET Record3-----------------------
	@GetMapping(value = "/record3")
	public void getRecord3(Model model, HttpSession session) throws Exception{
		model.addAttribute("userid", session.getAttribute("userid")); // login_message userid
	}
	
	// #220818 슬
	// ----------------게임 결과 통계 gamecode&month _POST Record3-----------------------
	@ResponseBody
	@RequestMapping(value = "/record3", method = {RequestMethod.POST})
	public List<RecordDTO> postRecord3(RecordDTO recordDTO) throws Exception{
		List<RecordDTO> record3 = recordService.postRecord3(recordDTO);
		return record3;
	}
	
	// #220818 슬
	// ----------------게임 결과 통계 gamecode&month _POST Record3-----------------------
	@ResponseBody
	@RequestMapping(value = "/record32", method = {RequestMethod.POST})
	public List<RecordDTO> postRecord3_2(@RequestParam("selected_date") String date, RecordDTO recordDTO) throws Exception{
		logger.info("selected_date : {}", date); //selected_date:2022-08-18 (String)
		String year = date.substring(0,4);
		String month = date.substring(5,7);
		String day = date.substring(8,10);
		System.out.println("year = " +year +", month = "+ month+", day = "+day);
		
		List<RecordDTO> record3_2 = recordService.postRecord3_2(date);
		return record3_2;
	}
	
	// 220824 슬
	// ----------------게임 결과 통계 페이지 이동_GET Record4-----------------------
	@GetMapping(value="/record4")
	public void getRecord4(Model model, HttpSession session) throws Exception{
		model.addAttribute("userid", session.getAttribute("userid"));
	}
	
	// ----------------게임 결과 통계 Up&Down 상위 20명 생년월일 _POST Record4_1-----------------------
	@ResponseBody
	@RequestMapping(value= "/record/record4_1", method={RequestMethod.POST})
	public List<MemberDTO> postRecord4_1() throws Exception{
		List <MemberDTO> record4_1 = recordService.postRecord4_1();
		//logger.info("record4_1 : {}", record4_1);
		return record4_1;
	}
	
	// ----------------게임 결과 통계 가위바위보 승률 상위 20명 생년월일 _POST Record4_2-----------------------
	@ResponseBody
	@RequestMapping(value= "/record/record4_2", method={RequestMethod.POST})
	public List<MemberDTO> postRecord4_2() throws Exception{
		List <MemberDTO> record4_2 = recordService.postRecord4_2();
		//logger.info("record4_1 : {}", record4_1);
		return record4_2;
	}

}
