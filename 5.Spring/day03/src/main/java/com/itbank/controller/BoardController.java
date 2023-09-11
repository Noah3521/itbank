package com.itbank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
	
	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) throws IllegalStateException, IOException {
		
		int row = service.insert(dto);
	
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		
		return "redirect:/board/view/" + service.getMaxIdx();
	}
	
	@GetMapping({"/", "/list"})
	public String list(String query) {
		return "redirect:/board/list/1";
	}
	
	@GetMapping({"/{page}", "/list/{page}"})
	public ModelAndView list(@PathVariable("page") int page, String query) {
		ModelAndView mav = new ModelAndView("/board/list");
		int boardCount = service.getBoardCount(query);
//		System.out.println(query + "검색어의 결과 행 : " + boardCount);
		Paging paging = new Paging(page, boardCount);
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("paging", paging);
		param.put("query", query);
		
		List<BoardDTO> list = service.selectAll(param);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		
		ModelAndView mav = new ModelAndView("/board/view");
		mav.addObject("dto", service.selectOne(idx));
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("alter");
		int row = service.delete(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		if(row!=0) {			
			mav.addObject("msg", "삭제성공");
		} else {
			mav.addObject("msg", "삭제실패");
		}
		mav.addObject("url", "/board/");			
		return mav;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		mav.addObject("dto", service.selectOne(idx));
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx, BoardDTO dto) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView("alter");
		dto.setIdx(idx);
		int row = service.update(dto);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		if(row!=0) {			
			mav.addObject("msg", "수정 성공");
		} else {
			mav.addObject("msg", "수정 실패");
		}
		mav.addObject("url", "/board/view/"+idx);			
		return mav;
	}
	
	@PostMapping("/checkPwd") 
	@ResponseBody
	public String checkPwd(@RequestBody HashMap<String, Object> param) {
		boolean flag = false;
		int idx = Integer.parseInt(param.get("idx") + "");
		String input = param.get("input") + "";
		String password = service.selectOne(idx).getPassword();
		System.out.println("pass : " + password);
		System.out.println("idx : " + idx);
		System.out.println("input : " + input);
		if(input!=null) {
			flag = (password.equals(input));
		}
		System.out.println("flag : " + flag);
		return flag ? "true" : "false";
	}
}
