package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	@PostMapping("/register")
	public String registerPost(MemberDto dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("msg","아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register";
		}
	}

	
}
