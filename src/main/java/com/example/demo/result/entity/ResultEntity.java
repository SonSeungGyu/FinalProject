package com.example.demo.result.entity;

import com.example.demo.court.entity.CourtEntity;
import com.example.demo.matching.entity.MatchingEntity;

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
//2024-02-20 결과테이블 생성
public class ResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int resultNo;
	
	int resultHomePoint;
	
	int resultAwayPoint;
	
	@ManyToOne
	MatchingEntity resultMatchingNo;
}
