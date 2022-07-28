package bgm.bgmaster.domain;

public class RecordDTO {

	/*
		CREATE TABLE public.tbl_record (
			userid varchar(20) NOT NULL,
			gamecode varchar(2) NOT NULL,
			connecttime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
			winorlose varchar(1) NULL,
			recordtime varchar(10) NULL,
			recordcount varchar(100) NULL,
			CONSTRAINT tbl_record_pk PRIMARY KEY (userid, gamecode, connecttime)
		);
	*/
	//recodeCount recodeTime
	private String userid;
	private String gamecode;
	private String connectTime;
	private String winOrlose;
	private String recordTime;
	private String recordCount;

	
	//---------Getter/Setter---------
	
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getGamecode() {
		return gamecode;
	}


	public void setGamecode(String gamecode) {
		this.gamecode = gamecode;
	}


	public String getConnectTime() {
		return connectTime;
	}


	public void setConnectTime(String connectTime) {
		this.connectTime = connectTime;
	}


	public String getWinOrlose() {
		return winOrlose;
	}


	public void setWinOrlose(String winOrlose) {
		this.winOrlose = winOrlose;
	}


	public String getRecordTime() {
		return recordTime;
	}


	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}


	public String getRecordCount() {
		return recordCount;
	}


	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	//---------Constructor---------
	public RecordDTO() {	//기본생성자
		
	}

	public RecordDTO(String userid, String gamecode, String connectTime, String winOrlose, String recordTime,
			String recordCount) {
		super();
		this.userid = userid;
		this.gamecode = gamecode;
		this.connectTime = connectTime;
		this.winOrlose = winOrlose;
		this.recordTime = recordTime;
		this.recordCount = recordCount;
	}


	//---------toString---------
	@Override
	public String toString() {
		return "RecordDTO [userid=" + userid + ", gamecode=" + gamecode + ", connectTime=" + connectTime
				+ ", winOrlose=" + winOrlose + ", recordTime=" + recordTime + ", recordCount=" + recordCount + "]";
	}

}
