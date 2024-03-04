package com.example.demo.court.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.court.dto.CourtDto;
import com.example.demo.court.entity.CourtEntity;
import com.example.demo.court.repository.CourtRepository;
import com.example.demo.matching.dto.MatchingDto;


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

	
	@Override
	public void remove(String courtName) {
		Optional<CourtEntity> result = repository.findById(courtName);
		if(result.isPresent()) {
			repository.deleteById(courtName);
		}
		
	}


	@Override
	public CourtDto read(String courtName) {
		Optional<CourtEntity> result = repository.findById(courtName);
		if(result.isPresent()) {
			CourtEntity entity = result.get();
			CourtDto dto = entityToDto(entity);
			return dto;
		}
		return null;
	}


	@Override // 매칭 등록때 구장 조회하기 위해 만듦
	public List<CourtDto> list() {
		List<CourtEntity> entityList = repository.findAll();
		List<CourtDto> list = new ArrayList<>();
		list = entityList.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
		return list;
	}


	
	
	
	

}
