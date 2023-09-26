package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//	IDX         NOT NULL NUMBER         
//	TITLE       NOT NULL VARCHAR2(100)  
//	MEMBER4_IDX NOT NULL NUMBER         
//	CONTENT     NOT NULL VARCHAR2(4000) 
//	FILENAME             VARCHAR2(255)  
//	WDATE                DATE           
//	VIEWCOUNT            NUMBER         

public class BoardDTO {
	private int idx;
	private String title; 
	private int member4_idx;
	private String content;
	private String fileName;
	private Date wdate;
	private String viewCount;
	
	private MultipartFile upload;	// 첨부파일
	
	private String member4_userid;	// 조인
	private String member4_username;// 조인
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
	public int getMember4_idx() {
		return member4_idx;
	}
	public void setMember4_idx(int member4_idx) {
		this.member4_idx = member4_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public String getMember4_username() {
		return member4_username;
	}

	public String getMember4_userid() {
		return member4_userid;
	}
	
	void setMember4_userid(String member4_userid) {
		this.member4_userid = member4_userid;
	}
	void setMember4_username(String member4_username) {
		this.member4_username = member4_username;
	}
	
	
	
}
