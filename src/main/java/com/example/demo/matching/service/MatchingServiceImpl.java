package com.example.demo.matching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchStatus;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.repository.MatchingRepository;
import com.example.demo.member.dto.MemberDto;
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
	public List<MatchingEntity> getWaitingMatches() {
		List<MatchingEntity> list = matchingRepository.findByMatchStatus(MatchStatus.WAITING);
		return list;
	}
	
	@Override //매치가 완료된 매칭만 조회
	public List<MatchingEntity> getMatchedMatches() {
		List<MatchingEntity> list = matchingRepository.findByMatchStatus(MatchStatus.MATCHED);
		return list;
	}

	@Override //매칭
	public void applyMatch(MatchingDto id, MemberDto matchingAway) {
		// 해당 매칭 정보를 조회
		Optional<MatchingEntity> optional = matchingRepository.findById(id.getMatchingNo());
		MatchingEntity matchingEntity = optional.get();
		Optional<MemberEntity> awayTeam = memberRepository.findById(matchingAway.getMemberId());
		MemberEntity team = awayTeam.get();
		
		// 매칭 상태가 '대기 중'인지 확인
		if(matchingEntity.getMatchStatus() == MatchStatus.WAITING) {
			// 매칭을 신청한 팀을 설정
			matchingEntity.setMatchingAway(team);
			// 매칭 상태를 '매칭됨'으로 변경
			matchingEntity.setMatchStatus(MatchStatus.MATCHED);
		}
		matchingRepository.save(matchingEntity);
	}

	@Override //매칭 삭제  매칭을 등록한 회원만 삭제가능
	public boolean deleteMatch(String userId, int matchId) {
		Optional<MemberEntity> optional = memberRepository.findById(userId);
		MemberEntity user = optional.get();
		Optional<MatchingEntity> optional2 = matchingRepository.findById(matchId);
		MatchingEntity match = optional2.get();
		if(user.getMemberId().equals( match.getMatchingHome().getMemberId())) {
			matchingRepository.deleteById(matchId);
			return true;
		} else {
			return false;
		}
	}

}
