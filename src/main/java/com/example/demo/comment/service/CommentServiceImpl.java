package com.example.demo.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.entity.CommentEntity;
import com.example.demo.comment.repository.CommentRepository;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository repository;

	@Override
	public int register(CommentDto dto) {
		CommentEntity entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getCommentNo();
	}


	
	@Override
	public List<CommentDto> getListByCommentBoardNo(int boardNo) {
		BoardEntity board = BoardEntity.builder().boardNo(boardNo).build();  //엔티티 생성
		List<CommentEntity> entityList = repository.findByCommentBoardNo(board);
		List<CommentDto> dtoList = new ArrayList<>();
		for (CommentEntity entity : entityList) {
			CommentDto dto = entityToDto(entity);
			dtoList.add(dto);
		}

		return dtoList;
	}



	@Override
	public void remove(int boardNo) {
		repository.deleteByCommentBoardNo(boardNo);
	}



}
