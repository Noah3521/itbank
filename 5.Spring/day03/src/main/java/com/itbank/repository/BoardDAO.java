package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {
	
	String getVersion();
	
	int insert(BoardDTO dto);
	
	int getMaxIdx();

	List<BoardDTO> selectAll(HashMap<String, Object> param);

	BoardDTO selectOne(int idx);

	int delete(int idx);

	int update(BoardDTO dto);

	int getBoardCount(String query);

}
