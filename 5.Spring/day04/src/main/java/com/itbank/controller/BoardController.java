package com.itbank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.Paging;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private BoardService boardService;
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) throws IllegalStateException, IOException {
		
		int row = boardService.insert(dto);
		
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		
		return "redirect:/board/view/" + boardService.getMaxIdx();
	}
	
	@GetMapping({"/list", "/"})
	public String list() {
		return "redirect:/board/list/1";
	}
	
	@GetMapping({"/list/{page}", "/{page}"})
	public ModelAndView list(@PathVariable("page") int page, String query) {	
		ModelAndView mav = new ModelAndView("/board/list");
		int boardCount = boardService.getBoardCount(query);
		Paging paging = new Paging(page, boardCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("paging", paging);
		map.put("query", query);
		
		List<BoardDTO> list = boardService.selectAll(map);
		
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		BoardDTO dto = boardService.selectOne(idx);
		mav.addObject("dto", dto);
		System.out.println(dto != null ? "조회 성공" : "조회 실패");
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/alter");
		int row = boardService.delete(idx);
		if(row!=0) {
			mav.addObject("msg", "삭제되었습니다");
			System.out.println("삭제성공");
		} else {			
			mav.addObject("msg", "삭제실패");
			System.out.println("삭제실패");
		}
		mav.addObject("url", "/board/list");
		return mav;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		BoardDTO dto = boardService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx, BoardDTO dto) {
		ModelAndView mav = new ModelAndView("/board/alter");
		dto.setIdx(idx);
		int row = boardService.update(dto);
		if(row!=0) {
			mav.addObject("msg", "수정되었습니다");
			System.out.println("수정성공");
		} else {			
			mav.addObject("msg", "수정실패");
			System.out.println("수정실패");
		}
		mav.addObject("url", "/board/view/"+idx);
		return mav;
	}
	
	@ResponseBody
	@PostMapping("/checkPwd")
	public String checkPwd(@RequestBody Map<String, String> map) {
		if(map==null) return "false";
		boolean flag = boardService.selectOne(Integer.parseInt(map.get("idx") + ""))
				.getPassword()
				.contentEquals(map.get("input"));
		System.out.println("flag : " + flag);
		return flag ? "true" : "false";
	}
	
}
