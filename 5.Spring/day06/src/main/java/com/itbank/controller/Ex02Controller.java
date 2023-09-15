package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.FileComponent;
import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Controller
public class Ex02Controller {
	
	@Autowired private UploadDAO uploadDAO;
	@Autowired private FileComponent fileComponent;
	
	@GetMapping("/ex02")
	public ModelAndView ex02() {
		ModelAndView mav = new ModelAndView("ex02");
		List<UploadDTO> list = uploadDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/ex02/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		String storedFileName = uploadDAO.selectOne(idx).getStoredFileName();
		int row = uploadDAO.delete(idx);
		System.out.println(row + "행 삭제");
		if(row != 0) {
			boolean flag = fileComponent.delete(storedFileName);
			System.out.println(flag ? "파일삭제 성공" : "파일삭제 실패");
			System.out.println();
		}
		return "redirect:/ex02";
	}

}
