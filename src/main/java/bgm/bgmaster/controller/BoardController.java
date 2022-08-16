package bgm.bgmaster.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bgm.bgmaster.domain.BoardDTO;
import bgm.bgmaster.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	//---------리스트 호출 list---------
	@GetMapping(value = "/list")
	public void getList(Model model, HttpSession session) throws Exception{
		List<BoardDTO> list = service.getList();
		
		model.addAttribute("list",list);
		
		model.addAttribute("login_userid", session.getAttribute("userid"));
	}
	
	//---------게시글 내용 보기 view---------
	@GetMapping(value = "/view")
	public void getView(Model model, @RequestParam("bno") int bno) throws Exception{
		System.out.println("view controller 진입");

		BoardDTO view = service.getView(bno);
		model.addAttribute("view", view);
	}
	
	//---------게시글 삽입 write_GET---------
	@GetMapping(value = "/write")
	public void getWrite(Model model, HttpSession session) throws Exception{
		
		String userid = (String)session.getAttribute("userid");
		model.addAttribute("userid",userid);
		
	}

	//---------게시글 삽입 write_POST---------
	@PostMapping(value = "/write")
	public String postWrite(BoardDTO dto, HttpSession session) throws Exception{
		service.postWrite(dto);
		return "redirect:/board/list";
	}
	
	//---------게시글 수정 update_GET---------
	@GetMapping(value = "/update")
	public void getUpdate(Model model, @RequestParam("bno") int bno) throws Exception{
		BoardDTO update = service.getUpdate(bno);
		model.addAttribute("update", update);
	}
	
	//---------게시글 수정 update_POST---------
	@PostMapping(value ="/update")
	public String postUpdate(BoardDTO dto) throws Exception{
		service.postUpdate(dto);
		return "redirect:/board/view?bno="+dto.getBno();
	}

	//---------게시글 삭제 delete---------
	@RequestMapping(value = "/delete")
	public String getDelete(@RequestParam("bno") int bno) throws Exception{
		service.getDelete(bno);
		return "redirect:/board/list";
	}
	

}
