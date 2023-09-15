package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class Ex01Controller {
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(MultipartRequest request) throws IllegalStateException, IOException {
		String saveDirectory = "C:\\upload";
		File dir = new File(saveDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		MultipartFile f = request.getFile("upload");
		File dest = new File(saveDirectory, f.getOriginalFilename());
		f.transferTo(dest);
		System.out.println("input의 이름 : " + f.getName());
		System.out.println("원본 파일의 이름 : " + f.getOriginalFilename());
		System.out.println("파일의 컨텐트 타입 (형식)" + f.getContentType());
		System.out.println("파일 크기 : " + f.getSize());
		return "redirect:/ex01";
	}
}
