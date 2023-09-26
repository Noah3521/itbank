package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	@Select("select * from member2 where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login(MemberDTO dto);

	@Select("select * from member2 where userid = #{userid}")
	MemberDTO selectOne(String userid);

	@Select("select salt from member2 where userid = #{userid}")
	String getSalt(String userid);

//	@Insert("insert into member2 (userid, userpw, salt, username, email) "
//			+ "values (#{userid}, #{userpw}, #{salt}, #{username}, #{email})")
	int insert(MemberDTO dto);

	int insertMember(MemberDTO dto);

	List<MemberDTO> selectAll();

}
