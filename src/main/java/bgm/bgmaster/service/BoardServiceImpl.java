package bgm.bgmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.domain.BoardDTO;

import bgm.bgmaster.dao.BoardDAO;
import bgm.bgmaster.service.BoardService;

@Service
public class BoardServiceImpl  implements BoardService{
	
	@Autowired
	private BoardDAO dao;


	//---------리스트 호출---------
	@Override
	public List<BoardDTO> getList() throws Exception{
		return dao.getList();
	}
	
	//---------게시글 내용 보기 view---------
	@Override
	public BoardDTO getView(int bno) throws Exception{
		return dao.getView(bno);
	}
	
	//---------게시글 삽입 write_POST---------
	@Override
	public void postWrite(BoardDTO dto) throws Exception{
		dao.postWrite(dto);
	}
	
	//---------게시글 수정 update_GET---------
	@Override
	public BoardDTO getUpdate(int bno) throws Exception{
		System.out.println("-------update service 진입--------");
		return dao.getUpdate(bno);
	}
	
	//---------게시글 수정 update_POST---------
	@Override
	public void postUpdate(BoardDTO dto) throws Exception{
		dao.postUpdate(dto);
	}
	
	//---------게시글 삭제 delete---------
	@Override
	public void getDelete(int bno) throws Exception{
		dao.getDelete(bno);
	}
}
