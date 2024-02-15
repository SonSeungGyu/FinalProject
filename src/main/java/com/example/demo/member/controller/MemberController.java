package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	
	
}
