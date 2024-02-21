package com.example.demo.board.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;



public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	// 검색 기능 구현을 리자지토리에 추가
	List<BoardDto> findByTitleContaining(String keyword);
	
	
}
