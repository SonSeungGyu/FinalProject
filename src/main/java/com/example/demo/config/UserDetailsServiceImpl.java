package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.CustomUser;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberService service;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		
		System.out.println("login id : " + userName);
		
		MemberDto dto = service.read(userName);
		
		if(dto == null) {
			throw new UsernameNotFoundException("");
		}else {
			return new CustomUser(dto);
		}
		
		
	}

}
