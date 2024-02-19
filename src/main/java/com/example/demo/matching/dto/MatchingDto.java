package com.example.demo.matching.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MatchingDto {
	int matching_no;
	LocalDate matching_date;//매칭 날짜
	int matching_time;		//매칭 시간을 숫자값으로 주고 처리
	LocalDate reg_date;		//등록시간
	LocalDate mod_date;		//등록시간
	int team_home;			//먼저 매칭 등록한 팀
	int team_away;			//후에 매칭 신청한 팀
	int court_no;			//구장 번호
}
