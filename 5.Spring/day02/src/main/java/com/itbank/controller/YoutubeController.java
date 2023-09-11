package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.repository.YoutubeDAO;

@Controller
public class YoutubeController {
	
	// 컨트롤러 함수 반환형을 결정하기
	// 1) DB에서 불러온 데이터 혹은 다른 테이터를 JSP에게 넘겨줘야 하는가?
	// yes -> ModelAndView
	// 2) 요청 주소와 JSP의 이름이 일치하는가?
	// yes -> void, no -> String
	
	
	private YoutubeDAO dao;
	
	@Autowired
	public YoutubeController(YoutubeDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<YoutubeDTO> list = dao.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		/*** dto.movieTag의 문자열을 수정하는 코드 (service로 이동가능) ***/
		String movieTag = dto.getMovieTag();
		String[] s = movieTag.split(" ");
		s[1] = "width=\"720\"";
		s[2] = "height=\"405\"";
		dto.setMovieTag(String.join(" ", s));
		int row = dao.insert(dto);
		System.out.println("\n\t[" + row + "행이 추가되었습니다]" + "\n");
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}") 
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		dao.viewCntUp(idx);
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")	// <a href="">, location.href 모두 GET 메서드이다
	public String delete(@PathVariable("idx") int idx) {
		int row = dao.delete(idx);
		System.out.println("\n\t[" + row + "행이 삭제되었습니다]" + "\n");
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
