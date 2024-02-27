package com.example.demo.comment.service;

import java.util.List;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.entity.CommentEntity;
import com.example.demo.member.entitly.MemberEntity;



public interface CommentService {

	int register(CommentDto dto);

	List<CommentDto> getListByCommentBoardNo(int boardNo);

	boolean remove(int boardNo);
	
	
	
	default CommentEntity dtoToEntity(CommentDto dto) {

		MemberEntity member = MemberEntity.builder().memberId(dto.getCommentWriter()).build(); //엔티티 생성

		BoardEntity board = BoardEntity.builder().boardNo(dto.getCommentBoardNo()).build();  //엔티티 생성

		CommentEntity entity = CommentEntity.builder()
				.commentNo(dto.getCommentNo())
				.commentBoardNo(board)
				.commentContent(dto.getCommentContent())
				.commentWriter(member)
				.build();
		
		return entity;
	}

	default CommentDto entityToDto(CommentEntity entity) {

		CommentDto dto = CommentDto.builder()
				.commentNo(entity.getCommentNo())
				.commentBoardNo(entity.getCommentBoardNo().getBoardNo())
				.commentContent(entity.getCommentContent())
				.commentWriter(entity.getCommentWriter().getMemberId())
				.regDate(entity.getRegDate()) 
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
	
}
