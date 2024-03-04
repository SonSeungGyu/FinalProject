package com.example.demo.result.dto;

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
//2024-02-20 결과테이블 생성
public class ResultDto {
	int resultNo;
	
	int resultHomePoint;
	
	int resultAwayPoint;
	
	int resultMatchingNo;
}
