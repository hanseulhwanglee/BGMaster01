package bgm.bgmaster.domain;

public class MemberDTO {
	
	/*create table test.schematest.tbl_member(
			userid varchar(20) not null primary key,
			username varchar(20) null,
			userpassword varchar(20) null,
			telno varchar(20) null,
			email varchar(30) null,
			regdate timestamp null DEFAULT CURRENT_TIMESTAMP,
			authority_code varchar(1) null default '0',
<<<<<<< Updated upstream
			gender varchar(10) null default '0'
=======
			gender varchar(1) null default '0',
>>>>>>> Stashed changes
			birthday varchar(10) null
		);*/
	
	private String userid;
	private String username;
	private String userpassword;
	private String telno;
	private String email;
	private String regdate;
	private String authority_code;
	private String gender;
	private String birthday;
	
	
	//---------Getter/Setter---------
	public String getUserid(){
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getAuthority_code() {
		return authority_code;
	}
	public void setAuthority_code(String authority_code) {
		this.authority_code = authority_code;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
			
	//---------Constructor---------
	public MemberDTO() {} // 기본생성자
	
	public MemberDTO(String userid, String username, String userpassword, String telno, String email, String regdate,
			String authority_code, String gender, String birthday) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.telno = telno;
		this.email = email;
		this.regdate = regdate;
		this.authority_code = authority_code;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	//---------to String---------
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + ", telno="
				+ telno + ", email=" + email + ", regdate=" + regdate + ", authority_code=" + authority_code
				+ ", gender=" + gender + ", birthday=" + birthday + "]";
	}

	
	
	
}
