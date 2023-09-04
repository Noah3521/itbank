package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;

public class AlbumDeleteController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param!=null) {
			int id = Integer.parseInt(param);
			AlbumDTO dto = albumDAO.selectOne(id);
			int row = albumDAO.delete(id);
			System.out.println("\n\t" + row + "행이 삭제되었습니다");
			
			if(row!=0 && dto.getCoverimg()!=null) {
				System.out.println(fileUtil.deleteAlbumImg(dto.getCoverimg()) ? "파일삭제 성공" : "파일삭제 실패");
			}
		}
		return "redirect:/album";
	}
}
