package com.example.demo.reviewTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.program.entity.ProgramEntity;
import com.example.demo.review.entity.ReviewEntity;
import com.example.demo.review.repository.ReviewRepository;

@SpringBootTest
public class ReviewRepositoryTest {
	
	@Autowired
	ReviewRepository repository;
	
	@Test
	void 리뷰등록(){
		
		ProgramEntity program = ProgramEntity.builder()
							.programNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		MemberEntity member = MemberEntity.builder()
							.memberId("주요한").build();  // memberId(~) 괄호안에 db에 있는 Member테이블 pk값 넣기
		
		ReviewEntity review = ReviewEntity.builder().reviewNo(0).program(program).reviewWriter(member).build();
		
		repository.save(review);		
		
	}

	@Test
	void 프로그램별_댓글목록조회() {
		// 프로그램 객체 생성 
		ProgramEntity program = ProgramEntity.builder()
							.programNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		List<ReviewEntity> list = repository.findByProgram(program);
		
		for (ReviewEntity review : list) {
			System.out.println(review);
		}
		
	}
	
	
	@Test
	void 프로그램별_댓글일괄_삭제 () {
		ProgramEntity program = ProgramEntity.builder()
						.programNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		repository.deleteByProgram(program);
	}
	
}













