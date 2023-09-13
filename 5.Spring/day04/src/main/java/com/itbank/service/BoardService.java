package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardDAO boardDAO;
	
	private final String saveDirectory = "E:\\upload";
	
	public int insert(BoardDTO dto) throws IllegalStateException, IOException {
		MultipartFile file = dto.getUploadFile();
		if(file != null && file.getSize()!=0) {
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + "_" + file.getOriginalFilename();
			System.out.println("저장할 이름 : " + fileName);
			File desc = new File(saveDirectory, fileName);
			dto.setFileName(fileName);
			file.transferTo(desc);
		}
		
		return boardDAO.insert(dto);
	}

	public String getMaxIdx() {
		return boardDAO.getMaxIdx();
	}

	public List<BoardDTO> selectAll(Map<String, Object> map) {
		return boardDAO.selectAll(map);
	}

	public BoardDTO selectOne(int idx) {
		return boardDAO.selectOne(idx);
	}

	public int delete(int idx) {
		BoardDTO dto = boardDAO.selectOne(idx);
		if(dto.getFileName()!=null) {
			boolean flag = new File(saveDirectory, dto.getFileName()).delete();
			System.out.println(flag ? "기존 파일 삭제 성공" : "기존 파일 삭제 실패");
		}
		return boardDAO.delete(idx);
	}

	public int update(BoardDTO dto) {
		BoardDTO temp = boardDAO.selectOne(dto.getIdx());
		if(temp.getFileName()!=null) {
			boolean flag = new File(saveDirectory, temp.getFileName()).delete();
			System.out.println(flag ? "기존 파일 삭제 성공" : "기존 파일 삭제 실패");
		}
		return boardDAO.update(dto);
	}
	
	public int getBoardCount(String query) {
		return boardDAO.getBoardCount(query);
	}
	
}
