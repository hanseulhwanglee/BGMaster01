package bgm.bgmaster.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex/*")
public class EchoController {
	private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
	
	@GetMapping("/echo")
	public void getEcho(Model model, HttpSession session)throws Exception{
		logger.info("채팅(Echo)_GET 진입");
		
		String userid1 = (String)session.getAttribute("userid");
		model.addAttribute("userid1",userid1);
		logger.info("userid:{}",userid1);
		
	}
}
