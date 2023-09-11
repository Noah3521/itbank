package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.YoutubeDTO;

@Repository
public interface YoutubeDAO {
	
	@Select("select * from youtube order by idx")
	List<YoutubeDTO> selectList();

	@Insert("insert into youtube (title, channel, thumbnail, movieTag) values(#{title}, #{channel}, #{thumbnail}, #{movieTag})")
	int insert(YoutubeDTO dto);

	@Select("select * from youtube where idx=#{idx}")
	YoutubeDTO selectOne(int idx);

	@Delete("delete from youtube where idx = #{idx}")
	int delete(int idx);

	@Update("update youtube set viewcount=viewcount+1 where idx = #{idx}")
	int viewCntUp(int idx);	
}
