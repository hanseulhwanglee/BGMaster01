package bgm.bgmaster.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bgm.bgmaster.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE="BGMaster.memberMapper";

	//--------회원가입 signup_POST--------
	@Override
	public void postSignup(MemberDTO dto) throws Exception{
		sql.insert(NAMESPACE+".signup",dto);
	}
	
	//--------로그인 info Login_POST--------
	@Override
	public int postLogin(MemberDTO dto) throws Exception{
		return sql.selectOne(NAMESPACE+".logininfo",dto);
	}
}
