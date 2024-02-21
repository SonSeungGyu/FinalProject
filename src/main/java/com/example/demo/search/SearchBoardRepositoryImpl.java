package com.example.demo.search;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.demo.board.entity.BoardEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{

	public SearchBoardRepositoryImpl() {
		super(BoardEntity.class);
	}
	
	@Override
	public BoardEntity search1() {
		
		 
		return null;
		
	}

}
