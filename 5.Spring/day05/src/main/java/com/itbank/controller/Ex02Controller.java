package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.Ex02DTO;

@Controller

public class Ex02Controller {
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Ex02DTO dto) throws IllegalStateException, IOException {
		File dir = new File("c:\\upload");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File dest = new File(dir, dto.getUpload().getOriginalFilename());
		dto.getUpload().transferTo(dest);
		System.out.println("title :" + dto.getTitle());
		System.out.println("upload :" + dto.getUpload().getOriginalFilename());
		System.out.println();
		
		return "redirect:/ex02";
	}
	
}
