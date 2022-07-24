package bgm.bgmaster.service;

import java.util.List;

import bgm.bgmaster.domain.BoardDTO;

public interface BoardService {

	//---------리스트 호출 list---------
	public List<BoardDTO> getList() throws Exception;
	
	//---------게시글 내용 보기 view---------
	public BoardDTO getView(int bno) throws Exception;

	//---------게시글 삽입 write_POST---------
	public void postWrite(BoardDTO dto) throws Exception;
	
	//---------게시글 수정 update_GET---------
	public BoardDTO getUpdate(int bno) throws Exception;
	
	//---------게시글 수정 update_POST---------
	public void postUpdate(BoardDTO dto) throws Exception;
	
	//---------게시글 삭제 delete---------
	public void getDelete(int bno) throws Exception;
}
