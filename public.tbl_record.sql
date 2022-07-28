CREATE TABLE public.tbl_record (
	userid varchar(20) NOT NULL,
	gamecode varchar(2) NOT NULL,
	connecttime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	winorlose varchar(10) NULL,
	recordtime varchar(10) NULL,
	recordcount varchar(100) NULL,
	CONSTRAINT tbl_record_pk PRIMARY KEY (userid, gamecode, connecttime)
);