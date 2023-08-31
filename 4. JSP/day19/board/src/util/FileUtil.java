package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.BoardDTO;

public class FileUtil {
	
	private static FileUtil instance = new FileUtil();
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {}
	
	private String saveDirectory = "E:\\board2_upload_file";
	
	private String encoding = "UTF-8";
	
	private int maxPostSize = 500 * 1024 * 1024;

	private DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	public BoardDTO getDTO(HttpServletRequest request) throws IOException {
		
		File dir = new File(saveDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		BoardDTO dto = new BoardDTO();
		MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);

		File f = mpRequest.getFile("uploadFile");
		
		String idx = mpRequest.getParameter("idx");
		
		dto.setTitle(mpRequest.getParameter("title"));
		dto.setWriter(mpRequest.getParameter("writer"));
		dto.setUploadFile(f!=null ? f.getName() : null);
		dto.setIdx(idx != null ? Integer.parseInt(idx) : 0);
		dto.setContent(mpRequest.getParameter("content"));
		
		System.out.println(mpRequest.getParameter("title"));
		System.out.println(mpRequest.getParameter("writer"));
		System.out.println(mpRequest.getParameter("content"));
		System.out.println();
		
		return dto;
	}
	
	public boolean delete(String fileName) {
		File f = new File(saveDirectory, fileName);
		return f.delete();
	}
	
}
