package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	public int join(MemberDTO dto) {
		//  새로운 솔트와 해시처리를 진행한 후 dao로 넘겨준다
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setUserpw(hash);
		dto.setSalt(salt);
		System.out.println("salt : " + salt);
		System.out.println("hash : " + hash);
		return memberDAO.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		
		MemberDTO login = memberDAO.selectByUserid(dto.getUserid());
		if(login!=null) {
			String dbpw = login.getUserpw();
			String userpw = hashComponent.getHash(dto.getUserpw(), login.getSalt());
			if(dbpw.equals(userpw)) {
				return login;
			}
		}
		
		return null;
	}
	
}
