package ex03;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUtil {
	
	private static FileUtil instance = new FileUtil();
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {}
	
	private String saveDirectory;
	private int maxPostSize = 10 * 1024 * 1024;
	private String encoding = "UTF-8";
	private DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	public Ex03DTO getDTO(HttpServletRequest request) throws IOException {
		Ex03DTO dto = null;
		
		if(saveDirectory == null) {
			ServletContext application = request.getServletContext();
			saveDirectory = application.getRealPath("upload");
			File dir = new File(saveDirectory);
			dir.mkdirs();
		}
		
		MultipartRequest mprequest = 
				new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		
		String title = mprequest.getParameter("title");
		File image = mprequest.getFile("image");
		String contentType = mprequest.getContentType("image");
		
		boolean flag1 = title.equals("") == false;
		boolean flag2 = image != null;
		boolean flag3 = flag2 && contentType.startsWith("image");
		
		
		if(flag1 && flag2 && flag3) {
			dto = new Ex03DTO();
			dto.setTitle(title);
			dto.setFilePath("upload/" + image.getName());
		}
		else if (image != null) {
			image.delete();
		}
		return dto;
	}
	
}
