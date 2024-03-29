package bgm.bgmaster.domain;

public class GameDTO {

	/*
		CREATE TABLE public.tbl_record (
			userid varchar(20) NOT NULL,
			game_code varchar(2) NOT NULL,
			connect_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
			win_or_lose varchar(10) NULL,
			record_time varchar(10) NULL,
			record_cnt varchar(100) NULL,
			CONSTRAINT tbl_record_pk PRIMARY KEY (userid, game_code, connect_time)
		);
	*/
	private String userid;
	private String game_code;
	private String connect_time;
	private String win_or_lose;
	private String record_time;
	private String record_cnt;

	
	//---------Getter/Setter---------
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getGame_code() {
		return game_code;
	}

	public void setGame_code(String game_code) {
		this.game_code = game_code;
	}

	public String getConnect_time() {
		return connect_time;
	}

	public void setConnect_time(String connect_time) {
		this.connect_time = connect_time;
	}

	public String getWin_or_lose() {
		return win_or_lose;
	}

	public void setWin_or_lose(String win_or_lose) {
		this.win_or_lose = win_or_lose;
	}

	public String getRecord_time() {
		return record_time;
	}

	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}

	public String getRecord_cnt() {
		return record_cnt;
	}

	public void setRecord_cnt(String record_cnt) {
		this.record_cnt = record_cnt;
	}
	
	//---------Constructor---------
	public GameDTO() {	//기본생성자
	}

	public GameDTO(String userid, String game_code, String connect_time, String win_or_lose, String record_time,
			String record_cnt) {
		super();
		this.userid = userid;
		this.game_code = game_code;
		this.connect_time = connect_time;
		this.win_or_lose = win_or_lose;
		this.record_time = record_time;
		this.record_cnt = record_cnt;
	}

	//---------toString---------
	@Override
	public String toString() {
		return "RecordDTO [userid=" + userid + ", game_code=" + game_code + ", connect_time=" + connect_time
				+ ", win_or_lose=" + win_or_lose + ", record_time=" + record_time + ", record_cnt=" + record_cnt + "]";
	}

	
}
