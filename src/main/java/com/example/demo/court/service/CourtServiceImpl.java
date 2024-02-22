package com.example.demo.court.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.court.dto.CourtDto;
import com.example.demo.court.entity.CourtEntity;
import com.example.demo.court.repository.CourtRepository;


@Service
public class CourtServiceImpl implements CourtService{

	
	@Autowired
	CourtRepository repository;
	
	
	@Override
	public void register(CourtDto dto) {
		CourtEntity entity = dtoToEntity(dto);
		repository.save(entity);
		
	}


	@Override
	public Page<CourtDto> getList(int pageNumber) {
		int pageNum = (pageNumber == 0) ? 0 : pageNumber -1;
		Pageable pageable = PageRequest.of(pageNum, 10);
		Page<CourtEntity> entityPage = repository.findAll(pageable);
		Page<CourtDto> dtoPage = entityPage.map(entity -> entityToDto(entity));
		return dtoPage;
		
	}


	
	
	
	

}
