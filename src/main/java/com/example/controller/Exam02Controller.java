package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {
	
	//sessionスコープを使うための設定
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	private String index() {
		//入力画面にフォワード
		return "exam02";
	}
	
	@RequestMapping("/info")
	public String ex02Info(int num1, int num2) {
		//sessionスコープにキーをつけて格納
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", num1+num2);
		//一つ目の結果画面にフォワード
		return "exam02-result";
	}
	
	@RequestMapping("/toPage2")
	public String toPage2() {
		//二ページ目にフォワード
		return "exam02-result2";
	}
}
