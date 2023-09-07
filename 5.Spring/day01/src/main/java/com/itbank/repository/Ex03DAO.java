package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.ArtistDTO;

@Repository
public interface Ex03DAO {
	
	@Select("select * from artist order by id")
	List<ArtistDTO> selectAll();
}
