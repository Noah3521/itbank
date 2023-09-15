package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//	IDX              NOT NULL NUMBER        
//	TITLE            NOT NULL VARCHAR2(100) 
//	STOREDFILENAME   NOT NULL VARCHAR2(500) 
//	ORIGINALFILENAME NOT NULL VARCHAR2(500) 

public class UploadDTO {
	
	private int idx;
	private String title;
	private String originalFileName;
	private String storedFileName;
	private MultipartFile upload;
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
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	

}
