package com.example.demo.comment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public boolean remove(int boardNo) {
		// 해당 댓글이 있는 확인
				Optional<CommentEntity>result  = repository.findById(boardNo);
				// isEmpty는 값이 없다면 false 로 반환 후 종료(값이 없다면 참) 
				if(result.isEmpty()) {
					return false;
				}
				// 있다면 댓글 삭제 후  true 반환
				repository.deleteById(boardNo);
				return true;
	}



}
