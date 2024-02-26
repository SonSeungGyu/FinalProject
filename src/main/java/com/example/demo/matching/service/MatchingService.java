package com.example.demo.matching.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.court.entity.CourtEntity;
import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entitly.MemberEntity;

public interface MatchingService {
	// 매칭 등록
	int creatMatching(MatchingDto dto);
	// 조회
	List<MatchingDto> getList();
	// 상세조회
	MatchingDto read(int matchingNo);
	// 매치
	void applyMatch(MatchingDto id, MemberDto matchingAway);
	// 삭제
	boolean deleteMatch(String userId, int matchId);
	
	public default MatchingEntity dtoToEntity(MatchingDto dto) {
	    MemberEntity homeTeam = MemberEntity.builder().memberId(dto.getMatchingHome()).build();
	    MemberEntity awayTeam = null;
	    if (dto.getMatchingAway() != null) {
	        awayTeam = MemberEntity.builder().memberId(dto.getMatchingAway()).build();
	    }
	    CourtEntity court = CourtEntity.builder().courtName(dto.getMatchingCourtName()).build();
	    LocalDate date = dto.getMatchingDate();
	    MatchingEntity entity = MatchingEntity.builder()
	    		.matchingHome(homeTeam)
	    		.matchingCourtName(court)
	    		.matchingDate(date)
	    		.matchingTime(dto.getMatchingTime())
	    		.matchStatus(dto.getMatchStatus()).build();
	    if (awayTeam != null) {
	    	entity.setMatchingAway(awayTeam);
	    }
	    return entity;
	}

	public default MatchingDto entityToDto(MatchingEntity entity) {
	    MatchingDto matchingDto = MatchingDto.builder()
	    		.matchingCourtName(entity.getMatchingCourtName().getCourtName())
	    		.matchingDate(entity.getMatchingDate())
	    		.matchingNo(entity.getMatchingNo())
	    		.matchingTime(entity.getMatchingTime())
	    		.matchStatus(entity.getMatchStatus())
	    		.matchingHome(entity.getMatchingHome().getMemberId())
	    		.regDate(entity.getRegDate())
	    		.modDate(entity.getModDate())
	    		.build();
	    if(entity.getMatchingAway() != null) {
	    	matchingDto.setMatchingAway(entity.getMatchingAway().getMemberId());
	    } else {
	    	matchingDto.setMatchingAway(null);
	    }
	    return matchingDto;
	}


}


