package bgm.bgmaster.dao;

import bgm.bgmaster.domain.MemberDTO;

public interface MemberDAO {
	
	//--------회원가입 signup_POST--------
	public void postSignup(MemberDTO dto) throws Exception;

	//--------로그인 info Login_POST--------
	public int postLogin(MemberDTO dto) throws Exception;
}
