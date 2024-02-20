package com.example.demo.boardTest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.member.entitly.MemberEntity;
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	BoardRepository repository;
	
	@Test public void 게시물30개추가() { 
		MemberEntity entity = MemberEntity.builder().memberId("user1").build();
		for (int i = 1; i <= 30; i++) { 
			BoardEntity boardEntity = BoardEntity.builder().boardTitle(i + "번글").boardContent("안녕하세요").boardWriter(entity).build();
			  repository.save(boardEntity); } 
		}
	@Test
	public void 게시물등록() {
		MemberEntity memberEntity = MemberEntity.builder().memberId("admin").build();
		BoardEntity boardEntity = BoardEntity.builder().boardTitle("ㅇㅇ").boardContent("ㅁㅁ").boardWriter(memberEntity).build(); repository.save(boardEntity);
		repository.save(boardEntity);
	}
	@Test
	public void 게시물전체조회() {
		List<BoardEntity> list =  repository.findAll();
		for(BoardEntity boardEntity : list) {
			System.out.println(boardEntity);
		}
	}
	@Test
	public void 게시물단건조회() {
		Optional<BoardEntity> optional = repository.findById(2);
		System.out.println(optional);
	}
	@Test
	public void 게시물수정() {
		Optional<BoardEntity> optional = repository.findById(2);
		BoardEntity boardEntity = optional.get();
		boardEntity.setBoardTitle("수정");
		boardEntity.setBoardContent("aa");
		repository.save(boardEntity);
	}
	@Test
	public void 게시물삭제() {
		repository.deleteById(2);
	}
}
