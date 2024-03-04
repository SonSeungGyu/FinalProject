package com.example.demo.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.member.dto.CustomUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			
		// 로그인한 사용자 정보 꺼내기
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		
		String username =authentication.getName();
		
		String pw = customUser.getPassword();
		
		boolean matchResult = passwordEncoder.matches("1111", pw);
		
		if(matchResult) {
			response.sendRedirect("/member/modify?id=" + username);
		}else {
			response.sendRedirect("/");
		}
		
	}

}
