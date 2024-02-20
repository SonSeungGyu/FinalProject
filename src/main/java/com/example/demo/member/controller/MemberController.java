package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
//	@PostMapping("/register")
//	public String registerPost(MemberDto dto, RedirectAttributes redirectAttributes) {
//		boolean isSuccess = service.register(dto);
//		if(isSuccess) {
//			return "redirect:/";
//		} else {
//			redirectAttributes.addFlashAttribute("msg","아이디가 중복되어 등록에 실패하였습니다");
//			return "redirect:/register";
//		}
//	}

	
}
