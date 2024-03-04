package com.example.demo.board.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.board.entity.BoardEntity;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	// 검색 기능 구현을 리자지토리에 추가
	Page<BoardEntity> findByboardTitleContaining(String keyword,Pageable pageable);
	
	
}
