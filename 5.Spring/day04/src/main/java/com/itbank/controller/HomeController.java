package com.itbank.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.TestDAO;

@Controller
public class HomeController {
	
	private TestDAO testDAO;
	
	@Autowired
	public HomeController(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		
		String version = testDAO.getVersion();
		Date sysdate = testDAO.getSysdate();
		List<String> tableList = testDAO.getTableInfo();
		
		mav.addObject("version", version);
		mav.addObject("sysdate", sysdate);
		mav.addObject("tableList", tableList);
		
		return mav;
	}
	
}
