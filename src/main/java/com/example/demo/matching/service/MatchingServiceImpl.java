package com.example.demo.matching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.repository.MatchingRepository;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.member.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MatchingServiceImpl implements MatchingService{
	@Autowired
	MatchingRepository matchingRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Transactional
	@Override //매칭 등록
	public int creatMatching(MatchingDto dto) {
		MatchingEntity matchingEntity = dtoToEntity(dto);
		matchingRepository.save(matchingEntity);
		int newNo = matchingEntity.getMatchingNo();
		return newNo;
	}

	@Override //대기 중인 매칭만 조회
	public List<MatchingDto> getWaitingMatches() {
		List<MatchingDto> list = matchingRepository.findByMatchStatus("WAITING");
		return list;
	}
	
	@Override //매치가 완료된 매칭만 조회
	public List<MatchingDto> getMatchedMatches() {
		List<MatchingDto> list = matchingRepository.findByMatchStatus("MATCHED");
		return list;
	}

	@Override //매칭
	public void applyMatch(int id, MemberEntity matchingAway) {
		// 해당 매칭 정보를 조회
		Optional<MatchingEntity> optional = matchingRepository.findById(id);
		MatchingEntity matchingEntity = optional.get();
		Optional<MemberEntity> awayTeam = memberRepository.findById(matchingAway.getMemberId());
		MemberEntity team = awayTeam.get();
		
		// 매칭 상태가 '대기 중'인지 확인
		if(matchingEntity.getMatchStatus() == "WAITING") {
			// 매칭을 신청한 팀을 설정
			matchingEntity.setMatchingAway(team);
			// 매칭 상태를 '매칭됨'으로 변경
			matchingEntity.setMatchStatus("MATCHED");
		}
		matchingRepository.save(matchingEntity);
	}

}
