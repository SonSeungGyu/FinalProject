package com.example.demo.member.service;

import org.springframework.data.domain.Page;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entitly.MemberEntity;

public interface MemberService {

	
	Page<MemberDto>getList(int pageNumber);
	
	boolean register(MemberDto dto);
	
	MemberDto read(String id);


	
	// 엔티티를 dto로 변환
	default MemberDto entityToDto(MemberEntity entity) {
		MemberDto dto = MemberDto.builder()
				.memberId(entity.getMemberId())
				.memberPassword(entity.getMemberPassword())
				.memberName(entity.getMemberName())
				.memberAddress(entity.getMemberAddress())
				.memberEmail(entity.getMemberEmail())
				.memberNumber(entity.getMemberNumber())
				.memberBirthDay(entity.getMemberBirthDay())
				.role(entity.getRole())
				.win(entity.getWin())
				.lose(entity.getLose())
				.point(entity.getPoint())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
		
	}
	
	
	// dto를 엔티티로 변환 
	default MemberEntity dtoToEntity(MemberDto dto) {
		MemberEntity entity = MemberEntity.builder()
				.memberId(dto.getMemberId())
				.memberPassword(dto.getMemberPassword())
				.memberName(dto.getMemberName())
				.memberAddress(dto.getMemberAddress())
				.memberEmail(dto.getMemberEmail())
				.memberNumber(dto.getMemberNumber())
				.memberBirthDay(dto.getMemberBirthDay())
				.role(dto.getRole())
				.win(dto.getWin())
				.lose(dto.getLose())
				.point(dto.getPoint())
				.build();
		return entity;
		
	}
}
