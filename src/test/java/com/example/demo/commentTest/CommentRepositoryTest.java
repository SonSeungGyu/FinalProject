package com.example.demo.commentTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.entity.CommentEntity;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.member.entitly.MemberEntity;

@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository repository;
	
	@Test
	void 댓글등록(){
		
		BoardEntity boardEntity = BoardEntity.builder()
							.boardNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		MemberEntity member = MemberEntity.builder()
							.memberId("주요한").build();  // memberId(~) 괄호안에 db에 있는 Member테이블 pk값 넣기
		
		CommentEntity comment = CommentEntity.builder().commentNo(0).board(boardEntity).commentWriter(member).build();
		
		repository.save(comment);		
		
	}

	@Test
	void 댓글목록조회() {
		// 프로그램 객체 생성 
		BoardEntity boardEntity = BoardEntity.builder()
							.boardNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		List<CommentEntity> list = repository.findByBoard(boardEntity);
		
		for (CommentEntity commentEntity : list) {
			System.out.println(commentEntity);
		}
		
	}
	
	
	@Test
	void 댓글일괄_삭제 () {
		BoardEntity boardEntity = BoardEntity.builder()
						.boardNo(0).build(); // programNo(~) 괄호안에 db에 있는 Program테이블 pk값 넣기
		
		repository.deleteByBoard(boardEntity);
	}
	
}













