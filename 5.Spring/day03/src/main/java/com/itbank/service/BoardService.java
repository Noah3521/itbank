package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	private BoardDAO dao;
	
	private final String saveDirectory = "E:\\upload";
	
	@Autowired
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}
	
	public String getVersion() {
		return dao.getVersion();
	}

	public int insert(BoardDTO dto) throws IllegalStateException, IOException {
		
		MultipartFile file = dto.getUploadFile();
		
		if(file!=null && file.getSize() != 0) {
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			File dest = new File(saveDirectory, fileName);
			file.transferTo(dest);
			dto.setFileName(fileName);
			System.out.println("파일 : " + fileName);
		}
		
		System.out.println("제목 : " + dto.getTitle());
		System.out.println("작성자 : " +  dto.getWriter());
		System.out.println("내용 : " + dto.getContent());
		
		return dao.insert(dto);
	}

	public int getMaxIdx() {
		return dao.getMaxIdx();
	}

	public List<BoardDTO> selectAll(HashMap<String, Object> param) {
		return dao.selectAll(param);
	}
	
	public BoardDTO selectOne(int idx) {
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
		
		if (selectOne(idx).getFileName() != null) {
			boolean isdel = new File(saveDirectory, selectOne(idx).getFileName()).delete();
			System.out.println(isdel ? "기존 파일이 삭제되었습니다" : "기존 파일 삭제 실패");
		}
		
		return dao.delete(idx);
	}

	public int update(BoardDTO dto) throws IllegalStateException, IOException {
		
		MultipartFile file = dto.getUploadFile();
		
		if(file!=null && file.getSize() != 0) {
			String oldFileName = selectOne(dto.getIdx()).getFileName(); 
			if (oldFileName!=null) {				
				boolean isdel = new File(saveDirectory, oldFileName).delete(); 
				System.out.println(isdel ? "기존 파일이 삭제되었습니다" : "기존 파일 삭제 실패");
			}
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			File dest = new File(saveDirectory, fileName);
			file.transferTo(dest);
			dto.setFileName(fileName);
			System.out.println("파일 : " + fileName);
		}
		
		return dao.update(dto);
	}

	public int getBoardCount(String query) {
		return dao.getBoardCount(query);
	}


	
}
