package com.example.demo.court.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tbl_court")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//2024-02-20 구장테이블 생성
public class CourtEntity {
	@Id
	String courtName;
	
	@Column(length = 100,nullable = false)
	String courtAddress;
}
