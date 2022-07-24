package bgm.bgmaster.domain;

public class BoardDTO {

	/*create table test.schematest.tbl_board(
			bno serial not null primary key,
			title varchar(50) not null,
			content text not null,
			writer varchar(30) not null,
			regDate timestamp not null DEFAULT CURRENT_TIMESTAMP,
			viewCnt int null,
			filename varchar(200) null,
			filesize int null
		)
		
	insert into gittest.schematest.tbl_board (title, content, writer)
		values ('title2', 'content2','writer2');
		*/
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private int viewCnt;
	private String filename;
	private int filesize;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	
	//---------Constructor---------
	public BoardDTO() {} // 기본생성자
	
	public BoardDTO(int bno, String title, String content, String writer, String regDate, int viewCnt, String filename,
			int filesize) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.filename = filename;
		this.filesize = filesize;
	}
	
	
	//---------toString---------
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate="
				+ regDate + ", viewCnt=" + viewCnt + ", filename=" + filename + ", filesize=" + filesize + "]";
	}
	


	
	
	

}