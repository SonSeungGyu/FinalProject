package com.example.demo.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")

public class NoticeController {
	@Autowired
	NoticeService service;
	
}
