package com.example.demo.board.service;

import org.springframework.data.domain.Page;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.member.entitly.MemberEntity;

public interface BoardService {
	int register(BoardDto dto);
	
	Page<BoardDto> getList(int pageNumber);
	
	BoardDto read(int no);
	
	void modify(BoardDto dto);
	
	int remove(int no);
	
	
	
	 default BoardEntity dtoToEntity(BoardDto dto) {
		  MemberEntity memberEntity = MemberEntity.builder().memberId(dto.getBoardWriter()).build();
		  BoardEntity boardEntity = BoardEntity.builder().boardWriter(memberEntity)
				  .boardTitle(dto.getBoardTitle()).boardContent(dto.getBoardContent()).build();
		  return boardEntity;
	  }
	 default BoardDto entityToDto(BoardEntity entity) {
		 BoardDto boardDto = BoardDto.builder().boardNo(entity.getBoardNo()).boardWriter(entity.getBoardWriter()
				 .getMemberId()).boardTitle(entity.getBoardTitle())
				 .boardContent(entity.getBoardContent()).regDate(entity.getRegDate())
				 .modDate(entity.getModDate()).build();
		  return boardDto;
	 }
	 
}
