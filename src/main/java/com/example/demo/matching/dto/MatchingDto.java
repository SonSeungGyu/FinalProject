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
   int matchingNo;
   LocalDate matchingDate;//매칭 날짜
   int matchingTime;      //매칭 시간을 숫자값으로 주고 처리
   LocalDate regDate;      //등록시간
   LocalDate modDate;      //등록시간
   int teamHome;         //먼저 매칭 등록한 팀
   int teamAway;         //후에 매칭 신청한 팀
   int courtNo;         //구장 번호
}
