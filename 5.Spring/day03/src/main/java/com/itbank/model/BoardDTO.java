package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//-------- -------- ------------- 
//IDX      NOT NULL NUMBER        
//TITLE    NOT NULL VARCHAR2(255) 
//CONTENT  NOT NULL CLOB          
//WRITER            VARCHAR2(50)  
//PASSWORD          VARCHAR2(50)  
//RDATE             DATE          



public class BoardDTO {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String password;
	private Date rdate;
	private MultipartFile uploadFile;
	private String fileName;
	
	

	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
