package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
	
	private String saveDirectory = "C:\\upload";
	
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}

	public String upload(MultipartFile f) {
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "");
		storedFileName += ext;
		File dest = new File(saveDirectory, storedFileName);
		try {
			f.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return storedFileName;
	}

	public boolean delete(String storedFileName) {
		File f = new File(saveDirectory, storedFileName);
		return f.delete();
	}
	
	
}
