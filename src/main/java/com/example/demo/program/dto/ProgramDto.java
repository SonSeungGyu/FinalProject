package com.example.demo.program.dto;

import java.time.LocalDateTime;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.program.entity.ProgramEntity;

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
@Builder
@ToString

public class ProgramDto {
	int programNo;
	String programName;
	String programContent;
	int programPrice;
	String memberId;
	String trainerId;
	LocalDateTime regDate;
	LocalDateTime modDate;
}
