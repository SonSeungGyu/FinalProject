package com.example.demo.court.service;

import org.springframework.data.domain.Page;

import com.example.demo.court.dto.CourtDto;
import com.example.demo.court.entity.CourtEntity;

public interface CourtService {

	
	void register(CourtDto dto);
	
	
	Page<CourtDto> getList(int pageNum);
	
	
	// 엔티티를 dto로 변환
	default CourtDto entityToDto(CourtEntity entity) {
		CourtDto dto = CourtDto.builder()
				.courtName(entity.getCourtName())
				.courtAddress(entity.getCourtAddress())
				.build();
		return dto;
		
	}
	
	//dto를 entity로 
	default CourtEntity dtoToEntity(CourtDto dto) {
		CourtEntity entity = CourtEntity.builder()
				.courtName(dto.getCourtName())
				.courtAddress(dto.getCourtAddress())
				.build();
		return entity;
		
	}
	

}
