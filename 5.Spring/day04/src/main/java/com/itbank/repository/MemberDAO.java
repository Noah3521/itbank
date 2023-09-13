package com.itbank.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface MemberDAO {
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login1(String userid, String userpw);
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login2(Map<String, String> param);
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login3(MemberDTO dto);
	
}
