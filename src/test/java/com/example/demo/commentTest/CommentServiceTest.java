package com.example.demo.commentTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.service.CommentService;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService commentService;
	
	@Test
	void 프로그램창에_댓글등록() {
		// ProgramEntity, MemberEntity db에 있는 값 입력해야.
		CommentDto dto = CommentDto.builder()
				.boardNo(1).commentWriter("주요한") // ProgramEntity, MemberEntity 테이블에 있는 값 입력해야
				.build();
		
		commentService.register(dto);
	}
	
	@Test
	void 프로그램별_댓글목록조회() {
		
		List<CommentDto> list = commentService.getListByBoardNo(0); 
		
		for (CommentDto dto : list) {
			System.out.println(dto);
		}
		
	}
	
	
	
	
	@Test
	void 특정댓글번호의_댓글삭제() {
		commentService.remove(1);
	}
	
	
	
}
