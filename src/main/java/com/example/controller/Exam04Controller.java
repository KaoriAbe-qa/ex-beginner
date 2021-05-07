package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/ex04")
public class Exam04Controller {

	@Autowired
	private HttpSession session;
	
	//フォームオブジェクトをスコープに格納
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		//入力画面にフォワード
		return "exam04";
	}
	
	@RequestMapping("/info")
	public String ex04Info(@Validated UserForm userForm //バリデーションが動くように
			, BindingResult result 	//エラーメッセージ格納オブジェクト
			, Model model) {		//requestスコープの準備
		
		//エラーがあったら入力画面に遷移
		if(result.hasErrors()) {
			return "exam04";
		}
		
		User user = new User();
		//フォームでまとめて受け取り
		//オブジェクトに格納
		user.setName(userForm.getName());
		user.setAge(userForm.getAge());
		user.setComment(userForm.getComment());
		//オブジェクトをスコープに格納
		session.setAttribute("user", user);
		//フォワード
		return "exam04-result";
	}
}
