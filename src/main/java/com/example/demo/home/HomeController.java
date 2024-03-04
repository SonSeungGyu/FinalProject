package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	@GetMapping("/")
	public String home() {
		return "home/main";
	}
	
	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}
	
	//0222 mypage 수정
//	@GetMapping("/mypage")
//	public String myPage() {
//		return "home/mypage";
//	}
}
