package com.example.demo.matchingTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.court.entity.CourtEntity;
import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.matching.repository.MatchingRepository;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class MatchingRepositoryTest {
	
	@Autowired
	MatchingRepository matchingRepository;
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 매칭등록() {
		LocalDate localDate = LocalDate.of(2024, 2, 26);
		MemberEntity user = MemberEntity.builder().memberId("user1").build();
		CourtEntity court = CourtEntity.builder().courtName("서창풋살장").build();
		MatchingEntity entity = MatchingEntity.builder().matchingDate(localDate).matchingTime(1).matchingHome(user).matchingCourtName(court)
				.build();
		matchingRepository.save(entity);
	}
	
	@Test //대기중인 매칭만 조회하기 위해 데이터 등록
	public void 매칭완료등록() {
		LocalDate localDate = LocalDate.of(2024, 2, 26);
		MemberEntity user = MemberEntity.builder().memberId("user1").build();
		MemberEntity user2 = MemberEntity.builder().memberId("user2").build();
		CourtEntity court = CourtEntity.builder().courtName("서창풋살장").build();
		MatchingEntity entity = MatchingEntity.builder().matchingDate(localDate).matchingTime(1).matchingHome(user).matchingCourtName(court)
				.matchingAway(user2).matchStatus("MATCHED").build();
		matchingRepository.save(entity);
	}
	
	@Test
	public void 대기중인매칭만조회() {
		List<MatchingEntity> list = matchingRepository.findByMatchStatus("WAITING");
		for(MatchingEntity entity : list) {
			System.out.println(entity);
		}
	}
	
	@Test
	public void 매칭() {
		Optional<MemberEntity> optional2 = memberRepository.findById("user2");
		MemberEntity awayTeam = optional2.get();
		Optional<MatchingEntity> optional = matchingRepository.findById(1);
		MatchingEntity entity = optional.get();
		
		if(entity.getMatchStatus() == "WAITING") {
			entity.setMatchingAway(awayTeam);
			entity.setMatchStatus("MATCHED");
		}
		matchingRepository.save(entity);
	}
}
