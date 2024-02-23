package com.example.demo.matchingTest;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;
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
		List<MatchingEntity> list = matchingService.getWaitingMatches();
		for(MatchingEntity matchingEntity : list) {
			System.out.println(matchingEntity);
		}
	}
	
	@Test
	public void 매치가완료된매칭만조회() {
		List<MatchingEntity> list = matchingService.getMatchedMatches();
		for(MatchingEntity matchingEntity : list) {
			System.out.println(matchingEntity);
		}
	}
	
	@Test
	public void 매치() {
		MatchingDto dto = MatchingDto.builder().matchingNo(14).build();
		MemberDto matchingAway = MemberDto.builder().memberId("user2").build();
        matchingService.applyMatch(dto, matchingAway);
	}
	
	@Test // 매칭을 등록한 사람만 삭제 가능
	public void 매치삭제() {
		matchingService.deleteMatch("user1", 2);
	}
}
