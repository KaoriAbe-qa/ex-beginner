package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {
	//問題文よりアプリケーションスコープを使用
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		//入力画面にフォワード
		return "exam03";
	}
	
	@RequestMapping("/info")
	public String ex03Info(int item1, int item2, int item3) {
		int taxEx = item1+item2+item3;
		int taxIn = (int) ((item1+item2+item3)*1.1);
		
		application.setAttribute("taxEx", taxEx);
		application.setAttribute("taxIn", taxIn);
		return "exam03-result";
	}
}
