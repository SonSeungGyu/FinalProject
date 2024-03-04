package com.example.demo.matching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchStatus;
import com.example.demo.matching.entity.MatchVictory;
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
	
	@Override
	public List<MatchingDto> getList() {
		List<MatchingEntity> entities = matchingRepository.findAll();
		List<MatchingDto> list = new ArrayList<>();
		list = entities.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
		return list;
	}

	@Override
	public MatchingDto read(int matchingNo) {
		Optional<MatchingEntity> optional = matchingRepository.findById(matchingNo);
		if(optional.isPresent()) {
			MatchingEntity entity = optional.get();
			MatchingDto dto = entityToDto(entity);
			return dto;
		} else {
			return null;
		}
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

	@Override
	public void matchVictory(MatchingDto dto, MemberDto matchingHome, MemberDto matchingAway, MatchVictory matchVictory) {
	    // 해당 매칭 정보를 조회
	    Optional<MatchingEntity> optional = matchingRepository.findById(dto.getMatchingNo());
	    optional.ifPresent(matchingEntity -> {
	        // 홈 팀 정보 조회
	        Optional<MemberEntity> optional2 = memberRepository.findById(matchingHome.getMemberId());
	        optional2.ifPresent(homeTeam -> {
	            // 어웨이 팀 정보 조회
	            Optional<MemberEntity> optional3 = memberRepository.findById(matchingAway.getMemberId());
	            optional3.ifPresent(awayTeam -> {
	                // 승 패 정보 저장
	                matchingEntity.setHomeMatchVictory(matchVictory);
	                matchingRepository.save(matchingEntity);

	                // 홈 팀 승, 패, 승점 정보
	                int homeTeamWin = homeTeam.getWin();
	                int homeTeamLose = homeTeam.getLose();
	                int homeTeamPoint = homeTeam.getPoint();
	                // 어웨이 팀 승, 패, 승점 정보
	                int awayTeamWin = awayTeam.getWin();
	                int awayTeamLose = awayTeam.getLose();
	                int awayTeamPoint = awayTeam.getPoint();

	                if (matchingEntity.getHomeMatchVictory() == MatchVictory.WIN) {
	                    homeTeam.setWin(++homeTeamWin);
	                    homeTeam.setPoint(homeTeamPoint += 3);
	                    awayTeam.setLose(++awayTeamLose);
	                    awayTeam.setPoint(++awayTeamPoint);
	                    matchingEntity.setAwayMatchVictory(MatchVictory.LOSE);
	                } else if (matchingEntity.getHomeMatchVictory() == MatchVictory.LOSE) {
	                    homeTeam.setLose(++homeTeamLose);
	                    homeTeam.setPoint(++homeTeamPoint);
	                    awayTeam.setWin(++awayTeamWin);
	                    awayTeam.setPoint(awayTeamPoint += 3);
	                    matchingEntity.setAwayMatchVictory(MatchVictory.WIN);
	                }
	                memberRepository.save(homeTeam);
	                memberRepository.save(awayTeam);
	            });
	        });
	    });
	}


	

}
