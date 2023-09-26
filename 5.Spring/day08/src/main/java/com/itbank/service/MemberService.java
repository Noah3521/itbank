package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	public MemberDTO login(MemberDTO dto) {
		// 1) 해시처리 되지 않은 사용자 입력값(request에 담겨서 넘어온 데이터)을 받아서
		String userpw = dto.getUserpw();
		
		// 2) DB에 저장된 값과 비교할 수 있도록 해시처리하고 난 값을 DAO에게 넘겨준다
		String salt = memberDAO.getSalt(dto.getUserid());
		if (salt!=null) {			
			dto.setUserpw(hashComponent.getHash(userpw, salt));
		}
		
		// 3) DAO에 의해 처리된 값(객체)을 컨트롤러에게 반환하여 이후 처리를 진행하도록 한다
		return memberDAO.login(dto);
	}

	public int join(MemberDTO dto) {
	
		String salt = hashComponent.getRandomSalt();
		dto.setSalt(salt);
		
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setUserpw(hash);		
		
		return memberDAO.insertMember(dto);
	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = memberDAO.selectAll();
		list.forEach(ob -> ob.setUserpw("x"));
		return list;
	}
	
}
