package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex01")
public class Exam01Controller {

	@RequestMapping("")
	public String index() {
		//入力画面にフォワード
		return "exam01";
	}
	
	@RequestMapping("/info")
	public String ex01Info(String name, Model model) {
		model.addAttribute("name", name);
		//結果画面へフォワード
		return "exam01-result";
	}
}
