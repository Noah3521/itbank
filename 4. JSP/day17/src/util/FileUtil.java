package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board2.BoardDTO;

public class FileUtil {
	
	private static FileUtil instance = new FileUtil();
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	private String saveDirectory = "E:\\upload";
	private int maxPostSize = 10 * 1024 * 1024;
	private String encoding = "UTF-8";
	private FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	public BoardDTO getDTO(HttpServletRequest request) throws IOException {
		
		File dir = new File(saveDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		BoardDTO dto = new BoardDTO();
		
		MultipartRequest mpRequest = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy
		);
		
		File f= mpRequest.getFile("image");
		
		String contentType = mpRequest.getContentType("image");
		
		String idx = mpRequest.getParameter("idx");
		dto.setIdx(idx!=null ? Integer.parseInt(idx) : 0);
		dto.setTitle(mpRequest.getParameter("title"));
		dto.setWriter(mpRequest.getParameter("writer"));
		dto.setContent(mpRequest.getParameter("content"));
		
		if (f!=null && contentType.startsWith("image")) {			
			dto.setUploadFile(f.getName());
		}
		
		return dto;
	}
	
	public void deleteFile(String fileName) {
		if(fileName!=null) {
			File f = new File(saveDirectory + "\\" + fileName);
			f.delete();
		}
	}
	
}
