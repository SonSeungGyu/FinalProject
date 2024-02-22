package com.example.demo.matching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.repository.MatchingRepository;
import com.example.demo.member.entitly.MemberEntity;

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
		List<MatchingEntity> list = repository.findByMatchStatus("WAITING");
		return list;
	}

	@Override //매칭
	public MatchingEntity applyMatch(int id, MemberEntity matchingAway) {
		// 해당 매칭 정보를 조회
		Optional<MatchingEntity> optional = repository.findById(id);
		MatchingEntity matchingEntity = optional.get();
		
		// 매칭 상태가 '대기 중'인지 확인
		if(matchingEntity.getMatchStatus() == "WAITING") {
			// 매칭을 신청한 팀을 설정
			matchingEntity.setMatchingAway(matchingAway);
			// 매칭 상태를 '매칭됨'으로 변경
			matchingEntity.setMatchStatus("MATCHED");
		}
		return repository.save(matchingEntity);
	}

}
