package com.example.demo.court.controller;

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

@Controller
@RequestMapping("/court")
public class CourtController {

	@Autowired
	CourtService service;
	
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0",name = "page")int page,Model model) {
		Page<CourtDto> list = service.getList(page);
		model.addAttribute("list", list);
		
	}
	
	//등록화면
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(CourtDto dto, RedirectAttributes redirectAttributes) {
		service.register(dto);
		
		return "redirect:/court/list";
	}


}
