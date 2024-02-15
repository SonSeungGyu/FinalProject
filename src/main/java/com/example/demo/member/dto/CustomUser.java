package com.example.demo.member.dto;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{
	public CustomUser(MemberDto dto) {
		super(dto.memberId, dto.memberPassword, Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));    
	  }
}
