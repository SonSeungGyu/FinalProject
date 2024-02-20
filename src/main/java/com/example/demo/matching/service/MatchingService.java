package com.example.demo.matching.service;

import java.util.List;

import com.example.demo.court.entity.CourtEntity;
import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchStatus;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.team.entity.TeamEntity;

public interface MatchingService {
	// 매칭 등록
	int creatMatching(MatchingDto dto);
	// 대기 중인 매칭만 조회
	List<MatchingEntity> getWaitingMatches();
	//매칭
	MatchingEntity applyMatch(int id, TeamEntity teamAway);
	
	default MatchingEntity dtoToEntity(MatchingDto dto) {
		TeamEntity homeTeam = TeamEntity.builder().teamNo(dto.getTeamHome()).build();
		TeamEntity awayTeam = TeamEntity.builder().teamNo(dto.getTeamAway()).build();
		CourtEntity court = CourtEntity.builder().courtName(dto.getMatchingCourtName()).build();
		MatchStatus status = dto.getStatus();
		MatchingEntity matchingEntity = MatchingEntity.builder().matchingCourtName(court).matchingDate(dto.getMatchingDate())
				.matchingTime(dto.getMatchingTime()).matchStatus(status).teamHome(homeTeam).teamAway(awayTeam).build();
		return matchingEntity;
	}
	default MatchingDto entityToDto(MatchingEntity entity) {
		MatchingDto matchingDto = MatchingDto.builder().matchingCourtName(entity.getMatchingCourtName().getCourtName())
				.matchingDate(entity.getMatchingDate()).matchingNo(entity.getMatchingNo()).matchingTime(entity.getMatchingTime())
				.status(entity.getMatchStatus()).teamHome(entity.getTeamHome().getTeamNo()).teamAway(entity.getTeamAway().getTeamNo())
				.build();
		return matchingDto;
				
	}
}
