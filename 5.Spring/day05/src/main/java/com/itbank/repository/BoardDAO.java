package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {
	
	@Select("select * from board4 order by idx desc")
	List<BoardDTO> selectAll();

	@Insert("insert into board4 (title, writer, content, pw) "
			+ "values(#{title}, #{writer}, #{content}, #{pw})")
	int insert(BoardDTO dto);

	@Select("select * from board4 where idx=#{idx}")
	BoardDTO selectOne(int idx);
	
	@Delete("delete board4 where idx = #{idx} and pw = #{pw}")
	int delete (BoardDTO dto);

	@Select("select * from board4 where idx = #{idx} and pw = #{pw}")
	BoardDTO selectOneByIdxAndPw(BoardDTO param);

	@Update("update board4 set title=#{title}, content=#{content} where idx=#{idx}")
	int update(BoardDTO dto);
	
}
