package bgm.bgmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgm.bgmaster.dao.MemberDAO;
import bgm.bgmaster.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO dao;
	
	//--------회원가입 signup_POST--------
	@Override
	public void postSignup(MemberDTO dto) throws Exception{
		dao.postSignup(dto);
	}
	
	//--------로그인 info Login_POST--------
	@Override
	public int postLogin(MemberDTO dto) throws Exception{
		return dao.postLogin(dto);
	}

}
