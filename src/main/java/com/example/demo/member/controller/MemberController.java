package com.example.demo.member.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	


	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

		Page<MemberDto> list = service.getList(page);

		model.addAttribute("list", list);

//		System.out.println("전체 페이지 수" + list.getTotalPages());
//		System.out.println("전체 회원 수" + list.getTotalElements());
//		System.out.println("현재 페이지 번호" + (list.getNumber() + 1));
//		System.out.println("페이지에 표시할 게시물 수" + list.getNumberOfElements());

	}

	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

	@PostMapping("/register")
	public String registerPost(MemberDto dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if (isSuccess) {
			return "redirect:/customlogin";
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/member/register";
		}
	}

	@GetMapping("/read")// /member 지움
	public void read(@RequestParam(defaultValue = "0", name = "id") String id,
			@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

		MemberDto dto = service.read(id);

		model.addAttribute("dto", dto);

		model.addAttribute("page", page);
	}

	//0222 myPage 추가
	@GetMapping("/mypage")
	public void myPage(Principal principal, Model model){
	
	String id = principal.getName();
	MemberDto dto = service.read(id);
	model.addAttribute("dto", dto);
	
	}
	
	
	
	
	//0222 mypage 수정 추가
	@GetMapping("/modify")
	public void modify(Principal principal, Model model){
		
	String id = principal.getName();
	MemberDto dto = service.read(id);
	model.addAttribute("dto", dto);
		
	}
	

	
	//0222 mypage 수정 추가
//	@PostMapping("/modify")
//	public String modifyPost(Principal principal, RedirectAttributes redirectAttribytes) {
//		String id = principal.getName();
//		MemberDto dto = service.read(id);
//		//dto.setMemberId(id);
//		service.modify(dto);
//		redirectAttribytes.addAttribute("memberId", dto.getMemberId());
//		return "redirect:/member/mypage";
//	}
	
	//0223
//	@PostMapping("/modify")
//	public String modifyPost(MemberDto dto, Principal principal,RedirectAttributes redirectAttribytes) {
//		String id = principal.getName();
//		dto = service.read(id);
//		service.modify(dto);
//		redirectAttribytes.addAttribute("memberId", dto.getMemberId());
//		return "redirect:/member/mypage";
//	}
	
	@PostMapping("/modify")
	public String modifyPost(MemberDto dto,RedirectAttributes redirectAttribytes) {
		service.modify(dto);
		redirectAttribytes.addAttribute("memberId", dto.getMemberId());
		return "redirect:/member/mypage";
	}
	
}
