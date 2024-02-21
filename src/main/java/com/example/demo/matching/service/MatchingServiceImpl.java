package com.example.demo.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchStatus;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.repository.MatchingRepository;
import com.example.demo.team.entity.TeamEntity;

@Service
public class MatchingServiceImpl implements MatchingService{
	@Autowired
	MatchingRepository repository;
	
	@Override //매칭 등록
	public int creatMatching(MatchingDto dto) {
		MatchingEntity matchingEntity = dtoToEntity(dto);
		repository.save(matchingEntity);
		int newNo = matchingEntity.getMatchingNo();
		return newNo;
	}

	@Override //대기 중인 매칭만 조회
	public List<MatchingEntity> getWaitingMatches() {
		List<MatchingEntity> list = repository.findByMatchStatus(MatchStatus.WAITING);
		return list;
	}

	@Override //매칭
	public MatchingEntity applyMatch(int id, TeamEntity teamAway) {
		// 해당 매칭 정보를 조회
		MatchingEntity matchingEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
		// 매칭 상태가 '대기 중'인지 확인
		if(matchingEntity.getMatchStatus() == MatchStatus.WAITING) {
			// 매칭을 신청한 팀을 설정
			matchingEntity.setTeamAway(teamAway);
			// 매칭 상태를 '매칭됨'으로 변경
			matchingEntity.setMatchStatus(MatchStatus.MATCHED);
		} else {
			throw new RuntimeException("The match is already matched");
		}
		return repository.save(matchingEntity);
	}

}
