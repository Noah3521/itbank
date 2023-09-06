package com.itbank.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.itbank.model.AlbumDTO;
import com.itbank.model.ArtistDTO;
import com.itbank.repository.AlbumDAO;
import com.itbank.repository.ArtistDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUtil {
	
	private String artistDirectory = "E:\\artist_img";
	private String albumDirectory = "E:\\album_img";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private int maxPostSize = 20 * 1024 * 1024;
	private String encoding = "UTF-8";
	private DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	private static FileUtil instance = new FileUtil(); 
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {
		File dir = new File(artistDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	public ArtistDTO getArtistDTO(HttpServletRequest request) throws IOException {
		
		ArtistDTO dto = new ArtistDTO();
		
		long ln = 0;
		
		MultipartRequest mpRequest = new MultipartRequest(
			request, artistDirectory, maxPostSize, encoding, policy
		);
		
		File f = mpRequest.getFile("profileimg");
		try {
			ln = sdf.parse(mpRequest.getParameter("debut")).getTime();
		} catch (Exception e) {}
		
		System.out.println("name : " + mpRequest.getParameter("name"));
		System.out.println("company : " + mpRequest.getParameter("company"));
		System.out.println("country : " + mpRequest.getParameter("country"));
		System.out.println("member : " + mpRequest.getParameter("member"));
		System.out.println("debut : " + mpRequest.getParameter("debut"));
		System.out.println("type : " + mpRequest.getParameter("type"));
		System.out.println("file : " + (f!=null ? f.getName() : null));
		
		dto.setName(mpRequest.getParameter("name"));
		dto.setCompany(mpRequest.getParameter("company"));
		dto.setCountry(mpRequest.getParameter("country"));
		dto.setMember(mpRequest.getParameter("member"));
		dto.setDebut(new Date(ln));
		dto.setType(mpRequest.getParameter("type"));
		dto.setProfileimg(f!=null ? f.getName() : null);
		
		String paramId = mpRequest.getParameter("id");
		if(paramId!=null) {
			String orignProfileImg = ArtistDAO.getInstance().selectOne(Integer.parseInt(paramId)).getProfileimg();
			if(f!=null && !orignProfileImg.equals(f.getName())) {
				boolean flag = deleteProfileImg(orignProfileImg);
				System.out.println(flag ? "\n\t파일 삭제 후 변경완료" : "\n\t파일삭제 실패");
			}
		}
		
		return dto;
	}

	public boolean deleteAlbumImg(String coverImg) {
		return new File(albumDirectory, coverImg).delete();
	}
	
	public AlbumDTO getAlbumDTO(HttpServletRequest request) throws IOException {
		
		AlbumDTO dto = new AlbumDTO();
		
		long ln = 0;
		
		MultipartRequest mpRequest = new MultipartRequest(
			request, albumDirectory, maxPostSize, encoding, policy
		);
		
		File f = mpRequest.getFile("coverimg");
		try {
			ln = sdf.parse(mpRequest.getParameter("rdate")).getTime();
		} catch (Exception e) {}
		
		System.out.println("artist_id : " + mpRequest.getParameter("artist_id"));
		System.out.println("name : " + mpRequest.getParameter("name"));
		System.out.println("type : " + mpRequest.getParameter("type"));
		System.out.println("rdate : " + mpRequest.getParameter("rdate"));
		System.out.println("playtime : " + mpRequest.getParameter("playtime"));
		System.out.println("file : " + (f!=null ? f.getName() : null));
		
		dto.setArtist_id(Integer.parseInt(mpRequest.getParameter("artist_id")));
		dto.setName(mpRequest.getParameter("name"));
		dto.setType(mpRequest.getParameter("type"));
		dto.setRdate(new Date(ln));
		dto.setPlaytime(Integer.parseInt(mpRequest.getParameter("playtime")));
		dto.setCoverimg(f!=null ? f.getName() : null);
		
		String paramId = mpRequest.getParameter("id");
		if(paramId!=null) {
			String orignCoverImg = AlbumDAO.getInstance().selectOne(Integer.parseInt(paramId)).getCoverimg();
			if(f!=null && !orignCoverImg.equals(f.getName())) {
				boolean flag = deleteAlbumImg(orignCoverImg);
				System.out.println(flag ? "\n\t파일 삭제 후 변경완료" : "\n\t파일삭제 실패");
			}
		}
		
		return dto;		
	}

	public boolean deleteProfileImg(String profileimg) {
		return new File(artistDirectory, profileimg).delete();
	}

	
}
