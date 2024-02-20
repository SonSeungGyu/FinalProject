package com.example.demo.court.dto;

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
//2024-02-20 구장테이블 생성
public class CourtDto {
	
	
	String courtName;
	String courtAddress;
}
