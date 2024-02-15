package com.example.demo.MemberServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.service.MemberService;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	MemberService service;
	
	@Test
	public void 회원조회() {}

	
}
