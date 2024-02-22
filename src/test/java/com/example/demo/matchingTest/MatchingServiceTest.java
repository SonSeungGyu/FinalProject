package com.example.demo.matchingTest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.service.MatchingService;

@SpringBootTest
public class MatchingServiceTest {
	
	@Autowired
	MatchingService matchingService;
	
	@Test
	public void 매칭등록() {
		LocalDate date = LocalDate.of(2024, 2, 26);
		MatchingDto matchingDto = MatchingDto.builder().matchingCourtName("서창풋살장").matchingDate(date)
				.matchingHome("user1").matchingTime(1).matchStatus("WAITING").build();
		matchingService.creatMatching(matchingDto);
	}
}
