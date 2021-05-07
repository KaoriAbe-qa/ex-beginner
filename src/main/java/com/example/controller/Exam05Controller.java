package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/ex05")
public class Exam05Controller {
	
	@Autowired
	private MemberRepository repository;
	
	@RequestMapping("")
	public String index() {
		//入力画面にフォワード
		return "exam05";
	}
	
	@RequestMapping("/info")
	public String ex05Info(String name, Model model) {
		
		//スコープに格納
		//findByNameの呼び出し
		model.addAttribute("memberList", repository.findByName(name));
		
		//結果画面にフォワード
		return "exam05-result";
	}

}
