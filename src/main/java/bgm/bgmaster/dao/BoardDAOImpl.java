package bgm.bgmaster.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE="BGMaster.boardMapper";
	
	//---------리스트 호출 list---------
	@Override
	public List<BoardDTO> getList() throws Exception{
		return sql.selectList(NAMESPACE+".selectlist");
	}
	
	//---------게시글 내용 보기 view---------
	@Override
	public BoardDTO getView(int bno) throws Exception{
		return sql.selectOne(NAMESPACE+".view", bno);
	}
	
	//---------게시글 삽입 write_POST---------
	@Override
	public void postWrite(BoardDTO dto) throws Exception{
		sql.insert(NAMESPACE+".write",dto);
	}
	//---------게시글 수정 update_GET---------
	@Override
	public BoardDTO getUpdate(int bno) throws Exception{
		return sql.selectOne(NAMESPACE+".view", bno);
	}
	
	//---------게시글 수정 update_POST---------
	@Override
	public void postUpdate(BoardDTO dto) throws Exception{
		sql.update(NAMESPACE+".update",dto);
	}
	
	//---------게시글 삭제 delete---------
	@Override
	public void getDelete(int bno) throws Exception{
		sql.delete(NAMESPACE+".delete", bno);
	}
}
