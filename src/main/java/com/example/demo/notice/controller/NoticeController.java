package com.example.demo.notice.controller;

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
	@PostMapping("/register")
	public String registerPost(NoticeDto noticeDto,RedirectAttributes redirectAttributes,Principal principal) {
		String id = principal.getName();
		noticeDto.setNoticeWriter(id);
		int no = service.register(noticeDto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/notice/list";
	}
	@GetMapping("/read")
	public void read(@RequestParam(name = "no")int no,@RequestParam(defaultValue = "0", name = "page")int page,Model model) {
		NoticeDto noticeDto = service.read(no);
		model.addAttribute("dto", noticeDto);
		model.addAttribute("page", page);
	}
	@GetMapping("/modify")
	public void modify(@RequestParam(name = "no")int no, Model model) {
		NoticeDto noticeDto = service.read(no);
		model.addAttribute("dto",noticeDto);
	}
	@PostMapping("/modify")
	public String modifyPost(NoticeDto noticeDto,RedirectAttributes redirectAttributes) {
		service.modify(noticeDto);
		redirectAttributes.addAttribute("no", noticeDto.getNoticeNo());
		return "redirect:/notice/read";
	}
	@PostMapping("/remove")
	public String removePost(@RequestParam(name = "no")int no) {
		service.remove(no);
		return "redirect:/notice/list";
	}
}
