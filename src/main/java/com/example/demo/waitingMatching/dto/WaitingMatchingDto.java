package com.example.demo.waitingMatching.dto;

import java.time.LocalDateTime;

import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.waitingMatching.entity.WaitingMatchingEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//2024-02-20 대기매칭테이블 생성
public class WaitingMatchingDto {
	int waitingMatchingNo;
	
	LocalDateTime waitingMatchingDate;
	
	int waitingMatchingMatchingNo;
	
	String waitingMatchingHomeTeam;
	
	String waitingMatchingAwayTeam;
}
