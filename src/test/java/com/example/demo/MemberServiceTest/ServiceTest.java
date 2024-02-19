package com.example.demo.MemberServiceTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	MemberService service;
	
	@Test
	public void 회원목록조회() {
		Page<MemberDto>page = service.getList(1);
		
		List<MemberDto>list =page.getContent();
		
		for(MemberDto dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 회원가입() {
		MemberDto dto = MemberDto.builder()
				.memberId("user3")
				.memberPassword("12444")
				.memberName("아산백호")
				.memberAddress("인천")
				.memberEmail("isu@naber.com")
				.memberNumber("010-1234-5678")
				.memberBirthDay("2001-07-07")
				.role("user")
				.build();
		boolean result = service.register(dto);
		System.out.println(result);
	}

	
	@Test
	public void 회원조회() {
		MemberDto dto = service.read("user1");
		System.out.println(dto);
	}

	
}
