package com.example.demo.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.entity.CommentEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

	List<CommentEntity> findByBoard (BoardEntity board);
	
	void deleteByBoard (BoardEntity program);
}
