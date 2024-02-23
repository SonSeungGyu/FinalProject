package com.example.demo.matching.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.service.MatchingService;
import com.example.demo.member.dto.MemberDto;

@Controller
@RequestMapping("/matching")
public class MatchingController {
	
	@Autowired
	MatchingService matchingService;
	
	@GetMapping("/register")
	public void matchingRegister() {
		
	}
	
	@PostMapping("/register")
	public String registerPost(MatchingDto matchingDto, RedirectAttributes redirectAttributes, Principal principal) {
		String id = principal.getName();
		matchingDto.setMatchingHome(id);
		int no = matchingService.creatMatching(matchingDto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/matching/list";
	}
	
	@GetMapping("/list")
	public void waitingList(Model model) {
		List<MatchingEntity> list = matchingService.getWaitingMatches();
		model.addAttribute("list", list);
	}
	
	
	 @PostMapping("/list") 
	 public String applyMatch(MatchingDto dto, Principal principal,RedirectAttributes redirectAttributes) {
		 String id = principal.getName();
		 MemberDto memberDto = MemberDto.builder().memberId(id).build();
		 matchingService.applyMatch(dto,memberDto);
		 redirectAttributes.addFlashAttribute("msg", dto.getMatchingNo());
		 return "redirect:/matching/matchedList";
	 }
	 
	
	@GetMapping("/matchedList")
	public void matchedList(Model model) {
		List<MatchingEntity> list = matchingService.getMatchedMatches();
		model.addAttribute("list", list);
	}
}
