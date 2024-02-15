package com.example.demo.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.notice.dto.NoticeDto;
import com.example.demo.notice.service.NoticeService;



@Controller
@RequestMapping("/notice")

public class NoticeController {
	@Autowired
	NoticeService service;
	
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0",name = "page")int page,Model model) {
		Page<NoticeDto> list = service.getList(page);
		model.addAttribute("list", list);
	}
	@GetMapping("/register")
	public void register() {
		
	}
}
