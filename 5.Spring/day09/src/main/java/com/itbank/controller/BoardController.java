package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@Autowired BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/board/list");
		List<BoardDTO> list = boardService.selectAll();
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto, HttpSession session) {
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if(login==null) {
			return "redirect:/board/list";
		}
		dto.setMember4_idx(login.getIdx());
		int idx = boardService.write(dto);
		System.out.println(idx + "행이 추가되었습니다");
		return "redirect:/board/view/"+idx;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		BoardDTO dto = boardService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = boardService.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/board/list";
	}
	
}
