package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.FileComponent;
import com.itbank.model.Ex03DTO;
import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Controller
public class Ex04Controller {

	@Autowired
	private UploadDAO uploadDAO;
	
	@Autowired
	private FileComponent fileComponent;
	
	@GetMapping("/ex04")
	public void ex04() {}
	
	@PostMapping("/ex04")
	public String ex04(Ex03DTO dto) {
		String title = dto.getTitle();
		for(MultipartFile f : dto.getUpload()) {
			System.out.println(f.getName() + " : " + f.getOriginalFilename());
			UploadDTO ob = new UploadDTO();
			String storedFileName = fileComponent.upload(f);
			ob.setTitle(title);
			ob.setOriginalFileName(f.getOriginalFilename());
			ob.setStoredFileName(storedFileName);
			int row = uploadDAO.insert(ob);
			System.out.println(row + "행이 삽입되었습니다");
		}
		return "redirect:/ex02";
	}
}
