package com.itbank.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	int insert(BoardDTO dto);

	String getMaxIdx();

	List<BoardDTO> selectAll(Map<String, Object> map);

	BoardDTO selectOne(int idx);

	int delete(int idx);

	int update(BoardDTO dto);

	int getBoardCount(String query);
}
