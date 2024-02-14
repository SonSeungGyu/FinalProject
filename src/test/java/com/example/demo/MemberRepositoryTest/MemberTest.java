package com.example.demo.MemberRepositoryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.member.repository.memberRepository;

@SpringBootTest
public class MemberTest {

	@Autowired
	memberRepository memberRepository;
	
	@Test
	public void 회원등록 () {
		MemberEntity entity = MemberEntity.builder()
				.memberId("user1")
				.memberPassword("1234")
				.memberName("뽀삐")
				.memberAddress("인천")
				.memberEmail("aaa@naver.com")
				.memberNumber("010-1234-5678")
				.memberBirthDay("1924-07-50")
				.build();
		memberRepository.save(entity);
	}
	
	
	
	@Test
	public void 조회() {
		
	}
	@Test
	public void 수정() {
		
	}
	@Test
	public void 삭제() {
		
	}
	
}
