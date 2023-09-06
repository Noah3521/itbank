package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.ArtistDTO;

public class ArtistDeleteController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param!=null) {
			int id = Integer.parseInt(param);
			ArtistDTO dto = artistDAO.selectOne(id);
			int row = artistDAO.delete(id);
			System.out.println("\n\t" + row + "행이 삭제되었습니다");
			if(row!=0 && dto.getProfileimg()!=null) {
				System.out.println(fileUtil.deleteProfileImg(dto.getProfileimg()) ? "파일삭제 성공" : "파일삭제 실패");
			}
		}
		return "redirect:/artist";
	}
}
