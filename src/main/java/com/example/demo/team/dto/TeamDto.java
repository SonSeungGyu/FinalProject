package com.example.demo.team.dto;

import java.time.LocalDateTime;

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
public class TeamDto {

	int teamNo;

	String teamName;

	String teamMember;
	String teamMember2;
	String teamMember3;
	String teamMember4;
	String teamMember5;
	String teamMember6;

	int teamWin;

	int teamLose;

	int teamPoint;

	String teamAddress;

	LocalDateTime regDate; // 회원이 최초로 만들어진 시간

	LocalDateTime modDate; // 회원 정보 수정된 시간

}
