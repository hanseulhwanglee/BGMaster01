package bgm.bgmaster.domain;

public class BoardDTO {

	/*create table public.tbl_board(
		bno serial not null primary key,
		title varchar(50) not null,
		content text not null,
		userid varchar(30) not null,
		reg_date timestamp not null DEFAULT CURRENT_TIMESTAMP,
		view_cnt int null,
		file_name varchar(200) null,
		file_size int null
	);
		
	insert into public.tbl_board (title, content, writer)
		values ('title2', 'content2','writer2');
		*/
	
	private int bno;
	private String title;
	private String content;
	private String userid;
	private String reg_date;
	private int view_cnt;
	private String file_name;
	private int file_size;
	
	//---------Getter/Setter---------
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	
	
	//---------Constructor---------
	public BoardDTO() {} // 기본생성자
	
	public BoardDTO(int bno, String title, String content, String userid, String reg_date, int view_cnt,
			String file_name, int file_size) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
		this.file_name = file_name;
		this.file_size = file_size;
	}

	//---------toString---------
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", userid=" + userid
				+ ", reg_date=" + reg_date + ", view_cnt=" + view_cnt + ", file_name=" + file_name + ", file_size="
				+ file_size + "]";
	}

	

	
	
	

}