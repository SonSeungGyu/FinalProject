package com.example.demo.commentTest;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.entity.CommentEntity;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.member.entitly.MemberEntity;

@SpringBootTest
public class commentRepositoryTest {
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void 댓글등록() {
		MemberEntity mEntity = MemberEntity.builder().memberId("htg").build();
		BoardEntity bEntity = BoardEntity.builder().boardNo(1).build();
		
		CommentEntity entity = CommentEntity.builder().commentContent("안녕")
				.commentWriter(mEntity).commentBoardNo(bEntity).build();
		
		commentRepository.save(entity);
	}
	
	@Test
	public void 댓글목록조회() {
		List<CommentEntity> list = commentRepository.findAll();
		for(CommentEntity comment : list) {
			System.out.println(comment);
		}
	}

	@Test
	public void 댓글단건조회() {
		Optional<CommentEntity> result = commentRepository.findById(1);
		if(result.isPresent()) {
			CommentEntity comment = result.get();
			System.out.println(comment);
		}
	}
	
	@Test
	public void 댓글수정() {
		// 기존 댓글 조회
		Optional<CommentEntity> result = commentRepository.findById(1);
		CommentEntity comment = result.get();
		// 일부 내용 변경
		comment.setCommentContent("내용이수정되었습니다~");
		// 댓글 수정
		commentRepository.save(comment);	
	}
	
	@Test
	public void 댓글삭제() {
		commentRepository.deleteById(1);
	}
}
