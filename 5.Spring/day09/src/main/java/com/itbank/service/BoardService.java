package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	@Autowired private FileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	
	
	public int write(BoardDTO dto) {
		// 파일 전송하고 파일 이름을 dto에 setting하여 insertBoard실행
		if (dto.getUpload().getSize()!=0) {			
			String fileName = fileComponent.upload(dto.getUpload());
			dto.setFileName(fileName);
		}
		int row = boardDAO.insertBoard(dto);
		if(row != 0) {
			row = boardDAO.getMaxIdx();
		}
		return row;
	}


	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}


	public BoardDTO selectOne(int idx) {
		return boardDAO.selectOne(idx);
	}


	public int delete(int idx) {
		
		// 만약 idx번 게시글의 첨부파일이 있으면 삭제하고
		String fileName = boardDAO.selectFileName(idx);
		if(fileName != null) {
			fileComponent.deleteFile(fileName);
		}
		// idx번 게시글을 delete처리한다
		return boardDAO.delete(idx);
	}
	
	
}
