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
	public void 댓글등록() {
		CommentDto dto = CommentDto.builder().commentBoardNo(1).commentWriter("htg").commentContent("안녕").build();
		commentService.register(dto);
	}
	
	@Test
	public void 댓글목록조회() {
		List<CommentDto>dtoList = commentService.getListByCommentBoardNo(1);
		for(CommentDto dto : dtoList) {
			System.out.println(dto);
		}
	}
	
	
	@Test
	public void 댓글삭제() {
		commentService.remove(1);
	}
}
