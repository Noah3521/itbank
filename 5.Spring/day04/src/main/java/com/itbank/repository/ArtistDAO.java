package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.ArtistDTO;

@Repository
public interface ArtistDAO {
	
	/* 
	 * 목록		select
	 * 단일조회	select ... where [PK]
	 * 검색		select ... where [param]
	 * 추가		insert 
	 * 삭제		delete ... [PK]
	 * 수정		update ... [PK]
	 */
	
	// 목록
	@Select("select * from artist")
	List<ArtistDTO> selectAll();
	
	// 단일조회
	@Select("select * from artist where id=#{id}")
	ArtistDTO selectOne(int id);
	
	// 검색
	@Select("select * from artist where instr(name, #{name}) > 0")
	ArtistDTO findByName(String name);
	
	// 추가
	@Insert("insert into artist(name, debut, type) values(#{name},#{debut},#{type})")
	int insert(ArtistDTO dto);
		
	// 삭제
	@Delete("delete artist where id=#{id}")
	int delete(int id);
	
	// 수정
	@Update("update artist set name=#{name}, debut=#{debut}, type=#{type}) where id=#{id}")
	int update(ArtistDTO dto);
}
