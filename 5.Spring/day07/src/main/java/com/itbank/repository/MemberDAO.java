package com.itbank.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	@Insert("insert into member2 (userid, userpw, username, salt, email) "
			+ " values (#{userid}, #{userpw}, #{username}, #{salt}, #{email})")
	int insert(MemberDTO dto);

	@Select("select * from member2 where userid=#{userid}")
	MemberDTO selectOneByUserid(String userid);

	@Update("update member2 set userpw=#{userpw}, salt=#{salt} where userid=#{userid} and email=#{email}")
	int updatePass(MemberDTO dto);


}
