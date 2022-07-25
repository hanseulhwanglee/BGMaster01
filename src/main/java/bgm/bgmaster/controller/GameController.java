package bgm.bgmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game/*")
public class GameController {
	
	@GetMapping(value="/updown")
	public void getUpdown() throws Exception{
		
	}

}
