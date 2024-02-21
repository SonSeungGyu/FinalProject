package com.example.demo.board.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.member.entitly.MemberEntity;

import jakarta.transaction.Transactional;

public interface BoardService {
	int register(BoardDto dto);
	
	Page<BoardDto> getList(int pageNumber);
	
	BoardDto read(int no);
	
	void modify(BoardDto dto);
	
	int remove(int no);
	
	// 검색 서비스 기능 구현(리파지토리에 추가 되었으니 서비스에서 기능 구현)
	List<BoardDto> search(String keyword);
	
	
	
	
	
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
