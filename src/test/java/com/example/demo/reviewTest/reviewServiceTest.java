package com.example.demo.reviewTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.program.dto.ProgramDto;
import com.example.demo.review.dto.ReviewDto;
import com.example.demo.review.service.ReviewService;

@SpringBootTest
public class reviewServiceTest {

	@Autowired
	ReviewService reviewService;
	
	@Test
	void 프로그램창에_댓글등록() {
		// ProgramEntity, MemberEntity db에 있는 값 입력해야.
		ReviewDto dto = ReviewDto.builder()
				.programNo(1).reviewWriter("주요한") // ProgramEntity, MemberEntity 테이블에 있는 값 입력해야
				.build();
		
		reviewService.register(dto);
	}
	
	@Test
	void 프로그램별_댓글목록조회() {
		
		List<ReviewDto> list = reviewService.getListByProgramNo(0); 
		
		for (ReviewDto dto : list) {
			System.out.println(dto);
		}
		
	}
	
	
	
	
	@Test
	void 특정댓글번호의_댓글삭제() {
		reviewService.remove(1);
	}
	
	
	
}
