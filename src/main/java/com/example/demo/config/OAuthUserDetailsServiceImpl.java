package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.CustomUser;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@Service
public class OAuthUserDetailsServiceImpl extends DefaultOAuth2UserService{

	@Autowired
	MemberService memberService;
	
	//로그인 함수 재정의
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		
		System.out.println("------------------------------------");
		System.out.println("userRequest : " + userRequest);
		
		String clientName = userRequest.getClientRegistration().getClientName();
		System.out.println(clientName); // 구글
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
        oAuth2User.getAttributes().forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
        
        //구글 로그인 할 경우, 사용자 정보에서 이메일 꺼내기
        String email = null;
        
        if(clientName.equals("Google")) {
        	email = oAuth2User.getAttribute("email");
        }
        
        System.out.println("EMAIL : " + email);
        // 자동 회원가입
        MemberDto memberDto = memberService.saveSocialMember(email);
        
		return new CustomUser(memberDto);
		
	}
	
	
}
