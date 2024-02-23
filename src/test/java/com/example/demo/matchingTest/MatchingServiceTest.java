package com.example.demo.matchingTest;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.service.MatchingService;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entitly.MemberEntity;

@SpringBootTest
public class MatchingServiceTest {
	
	@Autowired
	MatchingService matchingService;
	
	@Test
	public void 매칭등록() {
		LocalDate date = LocalDate.of(2024, 2, 26);
		MatchingDto matchingDto = MatchingDto.builder().matchingCourtName("서창풋살장").matchingDate(date)
				.matchingHome("user1").matchingTime(1).build();
		matchingService.creatMatching(matchingDto);
	}
	
	@Test
	public void 대기중인매칭만조회() {
		List<MatchingDto> list = matchingService.getWaitingMatches();
		for(MatchingDto matchingDto : list) {
			System.out.println(matchingDto);
		}
	}
	
	@Test
	public void 매치가완료된매칭만조회() {
		List<MatchingDto> list = matchingService.getMatchedMatches();
		for(MatchingDto matchingDto : list) {
			System.out.println(matchingDto);
		}
	}
	
	@Test
	public void 매치() {
		int id = 10;
		MemberEntity matchingAway = MemberEntity.builder().memberId("user2").build();
        matchingService.applyMatch(id, matchingAway);
	}
}
