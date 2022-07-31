package bgm.bgmaster.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bgm.bgmaster.domain.MemberDTO;
import bgm.bgmaster.service.MemberService;

@Controller
@RequestMapping("/member/*")

public class MemberController {

	@Autowired
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//--------회원가입 signup_GET--------
	@GetMapping(value = "/signup")
	public void getSignup() throws Exception{
		
	}
	
	//--------회원가입 signup_POST--------
	@PostMapping(value = "/signup")
	public String postSignup(MemberDTO dto) throws Exception{
		service.postSignup(dto);
		return "redirect:/member/login";
	}
	
	//--------로그인 Login_GET--------
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLogin() throws Exception{
		
	}

	//--------로그인 info Login_POST--------
	@ResponseBody
	@PostMapping(value = "/login")
	public int postLogin(MemberDTO dto, HttpSession session) throws Exception{
		//logger.info("로그인_POST진입");
		int result = service.postLogin(dto);
		//logger.info("로그인_POST진입___1");
		
		if(result == 1) {
			session.setAttribute("userid", dto.getUserid());
		}
		
		//logger.info("로그인_POST진입___2");
		//System.out.println("login info result : "+result);
		return result;
	}
	
	//--------로그아웃 Logout_GET--------
	@GetMapping(value="/logout")
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
}
