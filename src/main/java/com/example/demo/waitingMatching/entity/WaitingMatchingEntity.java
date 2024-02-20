package com.example.demo.waitingMatching.entity;

import java.time.LocalDateTime;

import com.example.demo.matching.entity.MatchingEntity;
import com.example.demo.result.entity.ResultEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tbl_result")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//2024-02-20 대기매칭테이블 생성
public class WaitingMatchingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int waitingMatchingNo;
	
	LocalDateTime waitingMatchingDate;
	
	@ManyToOne
	MatchingEntity waitingMatchingMatchingNo;
	
	@Column(length = 100,nullable = false)
	String waitingMatchingHomeTeam;
	
	@Column(length = 100,nullable = true)
	String waitingMatchingAwayTeam;
}
