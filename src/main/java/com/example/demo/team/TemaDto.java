package com.example.demo.team;

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
public class TemaDto {

	int teamNo;

	String teamName;

	String teamMember;

	int win;

	int lose;

	int point;

	String teamAddress;

	LocalDateTime regDate; // 회원이 최초로 만들어진 시간

	LocalDateTime modDate; // 회원 정보 수정된 시간

}
