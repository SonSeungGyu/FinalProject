package com.example.demo.member.dto;

import java.util.Arrays;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;

@Getter
public class CustomUser extends User implements OAuth2User{
	
		String password;
		
		Map<String, Object>attr;
	
	public CustomUser(MemberDto dto) {
		super(dto.getMemberId(), dto.getMemberPassword(),
				Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));  
		
		this.password = dto.getMemberPassword();
	  }

	@Override
	public Map<String, Object> getAttributes() {
		
		return this.attr;
	}

	@Override
	public String getName() {
		return null;
	}
}
