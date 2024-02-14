package com.example.demo.trainer;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TrainerDto {
	
	String trainerId; 		//id
	String trainerPassword; //password
	String trainerName;		//이름
	LocalDateTime regDate; // 회원이 최초로 만들어진 시간
	LocalDateTime modDate; // 회원 정보 수정된 시간
	
	
}
