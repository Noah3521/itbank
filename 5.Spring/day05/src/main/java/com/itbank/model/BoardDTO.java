package com.itbank.model;

import java.sql.Date;

//	IDX     NOT NULL NUMBER        
//	TITLE   NOT NULL VARCHAR2(100) 
//	WRITER  NOT NULL VARCHAR2(100) 
//	CONTENT NOT NULL CLOB          
//	WDATE            DATE     
//	PW      NOT NULL VARCHAR2(100) 

public class BoardDTO {	
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	private String pw;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}