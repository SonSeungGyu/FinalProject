package com.example.demo.MemberRepositoryTest;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class MemberTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 회원등록 () {
		MemberEntity entity = MemberEntity.builder()
				.memberId("user2")
				.memberPassword("1235")
				.memberName("뽀삐")
				.memberAddress("인천")
				.memberEmail("aaa@naver.com")
				.memberNumber("010-1234-5678")
				.memberBirthDay("1924-07-50")
				.role("회원")
				.build();
		memberRepository.save(entity);
	}
	
	
	
	@Test
	public void 조회() {
		Optional<MemberEntity>opt = memberRepository.findById("user1");
		MemberEntity entity = opt.get();
		System.out.println(entity);
	}
	@Test
	public void 수정() {
		Optional<MemberEntity>opt = memberRepository.findById("user1");
		MemberEntity entity = opt.get();
		entity.setMemberBirthDay("1995-08-06");
		memberRepository.save(entity);
	}
	@Test
	public void 삭제() {
		memberRepository.deleteById("user1");
	}
	
}
