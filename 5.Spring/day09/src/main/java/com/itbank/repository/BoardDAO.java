package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {


	int getMaxIdx();

	int insertBoard(BoardDTO dto);

	List<BoardDTO> selectAll();

	BoardDTO selectOne(int idx);

	int delete(int idx);

	String selectFileName(int idx);

}
