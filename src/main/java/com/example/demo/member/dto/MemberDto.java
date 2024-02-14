package com.example.demo.member.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {

	String memberId; // 회원 아이디(pk)

	String role; // 사용자 등급 추가 (사용자:ROLE_USER, 관리자:ROLE_ADMIN)
	
	String memberPassword; // 회원 비밀번호

	String memberName; // 회원 이름

	String memberAddress; // 회원 주소

	String memberEmail; // 회원 이메일

	String memberNumber; // 회원 전화번호

	String memberBirthDay; // 회원 생년월일 

	LocalDateTime regDate; // 회원이 최초로 만들어진 시간
	
	LocalDateTime modDate; // 회원 정보 수정된 시간
	
}
