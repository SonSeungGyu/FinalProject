package com.example.demo.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

}
