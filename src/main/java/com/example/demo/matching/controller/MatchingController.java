package com.example.demo.matching.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.court.dto.CourtDto;
import com.example.demo.court.service.CourtService;
import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchVictory;
import com.example.demo.matching.service.MatchingService;
import com.example.demo.member.dto.MemberDto;

@Controller
@RequestMapping("/matching")
public class MatchingController {
	
	@Autowired
	MatchingService matchingService;
	@Autowired
	CourtService service;
	
	@GetMapping("/register")
	public void matchingRegister(Model model) {
		List<CourtDto> list = service.list();
		model.addAttribute("list", list);
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
	public void list(Model model) {
		List<MatchingDto> list = matchingService.getList();
		model.addAttribute("list", list);
		
	}
	
	@PostMapping("/applyMatch")
	 public String applyMatch(MatchingDto dto, Principal principal,RedirectAttributes redirectAttributes) {
		 String id = principal.getName();
		 MemberDto memberDto = MemberDto.builder().memberId(id).build();
		 matchingService.applyMatch(dto,memberDto);
		 redirectAttributes.addFlashAttribute("msg", dto.getMatchingNo());
		 return "redirect:/matching/matchedList";
	 }
	 
	 @GetMapping("/read")
	 public void read(@RequestParam(name = "matchingNo")int matchingNo, Model model) {
		 MatchingDto dto = matchingService.read(matchingNo);
		 model.addAttribute("dto", dto);
	 }
	 
	 @GetMapping("/matchedList")
		public void matchedList(Model model) {
			List<MatchingDto> list = matchingService.getList();
			model.addAttribute("list", list);
			
	 }
	 @GetMapping("/matchingRead")
	 public void matchingRead(@RequestParam(name = "matchingNo")int matchingNo,Model model) {
		 MatchingDto dto = matchingService.read(matchingNo);
		 model.addAttribute("dto", dto);
	 }
	 @PostMapping("/matchVictory")
	 public String matchVictory(MatchingDto dto,RedirectAttributes redirectAttributes) {
		 MemberDto homeTeam = MemberDto.builder().memberId(dto.getMatchingHome()).build();
		 MemberDto awayTeam = MemberDto.builder().memberId(dto.getMatchingAway()).build();
		 MatchVictory matchVictory = null;
		 matchingService.matchVictory(dto, homeTeam, awayTeam, matchVictory);
		 redirectAttributes.addFlashAttribute("msg", dto.getMatchingNo());
		 return "redirect:/matching/matchedList";
	 }
}
