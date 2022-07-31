

create table public.tbl_board(
	bno serial not null primary key,
	title varchar(50) not null,
	content text not null,
	writer varchar(30) not null,
	reg_date timestamp not null DEFAULT CURRENT_TIMESTAMP,
	view_cnt int null,
	file_name varchar(200) null,
	file_size int null
);

create table public.tbl_member(
	userid varchar(20) not null primary key,
	username varchar(20) null,
	userpassword varchar(20) null,
	telno varchar(20) null,
	email varchar(30) null,
	reg_date timestamp null DEFAULT CURRENT_TIMESTAMP,
	authority_code varchar(1) null default '0',
	gender varchar(10) null default '0',
	birthday varchar(10) null
);

CREATE TABLE public.tbl_record (
	userid varchar(20) NOT NULL,
	game_code varchar(2) NOT NULL,
	connect_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	win_or_lose varchar(10) NULL,
	record_time varchar(10) NULL,
	record_cnt varchar(100) NULL,
	CONSTRAINT tbl_record_pk PRIMARY KEY (userid, game_code, connect_time)
);