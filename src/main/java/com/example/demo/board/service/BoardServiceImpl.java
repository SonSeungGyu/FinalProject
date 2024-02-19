package com.example.demo.board.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;
@Service

public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardRepository repository;

	@Override
	public int register(BoardDto dto) {
		BoardEntity boardEntity = dtoToEntity(dto);
		repository.save(boardEntity);
		int newNo = boardEntity.getBoardNo();
		return newNo;
	}

	@Override
	public Page<BoardDto> getList(int pageNumber) {
		int pageNum = (pageNumber == 0) ? 0 : pageNumber -1;
		Pageable pageable = PageRequest.of(pageNum, 10,Sort.by("boardNo").descending());
		Page<BoardEntity> entityPage = repository.findAll(pageable);
		Page<BoardDto> dtoPage = entityPage.map(entity -> entityToDto(entity));
		return dtoPage;
	}

	@Override
	public BoardDto read(int no) {
		Optional<BoardEntity> optional = repository.findById(no);
		if(optional.isPresent()) {
			BoardEntity boardEntity = optional.get();
			BoardDto boardDto = entityToDto(boardEntity);
			return boardDto;
		} else {
			return null;
		}
		
	}

	@Override
	public void modify(BoardDto dto) {
		Optional<BoardEntity> optional = repository.findById(dto.getBoardNo());
		BoardEntity boardEntity = optional.get();
		boardEntity.setBoardTitle(dto.getBoardTitle());
		boardEntity.setBoardContent(dto.getBoardContent());
		repository.save(boardEntity);
	}

	@Override
	public int remove(int no) {
		Optional<BoardEntity> optional = repository.findById(no);
		if(optional.isPresent()) {
			repository.deleteById(no);
			return 1;
		} else {
			return 0;
		}
		
	}
	
}
