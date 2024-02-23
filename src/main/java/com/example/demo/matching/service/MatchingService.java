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
	// 매치가 완료된 매칭만 조회
	List<MatchingEntity> getMatchedMatches();
	// 대기 중인 매칭만 조회
	List<MatchingEntity> getWaitingMatches();
	// 매치
	void applyMatch(MatchingDto id, MemberDto matchingAway);
	
	boolean deleteMatch(String userId, int matchId);
	
	default MatchingEntity dtoToEntity(MatchingDto dto) {
		MemberEntity homeTeam = MemberEntity.builder().memberId(dto.getMatchingHome()).build();
		MemberEntity awayTeam = null;
		if(dto.getMatchingAway() != null) {
			awayTeam = MemberEntity.builder().memberId(dto.getMatchingAway()).build();
		}
		CourtEntity court = CourtEntity.builder().courtName(dto.getMatchingCourtName()).build();
		LocalDate date = dto.getMatchingDate();
		MatchingEntity matchingEntity = MatchingEntity.builder().matchingAway(awayTeam).matchingHome(homeTeam).matchingCourtName(court)
				.matchingDate(date).matchingTime(dto.getMatchingTime()).matchStatus(dto.getMatchStatus()).build();
		return matchingEntity;
	}
	default MatchingDto entityToDto(MatchingEntity entity) {
		MatchingDto matchingDto = MatchingDto.builder().matchingCourtName(entity.getMatchingCourtName().getCourtName())
				.matchingDate(entity.getMatchingDate()).matchingNo(entity.getMatchingNo()).matchingTime(entity.getMatchingTime())
				.matchStatus(entity.getMatchStatus()).matchingHome(entity.getMatchingHome().getMemberId())
				.matchingAway(entity.getMatchingAway().getMemberId()).build();
		return matchingDto;
				
	}
}


