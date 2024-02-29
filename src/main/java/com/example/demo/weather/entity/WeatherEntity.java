package com.example.demo.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_weather")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int weatherId;
	
	String baseDate; // 발표 일자
	
	String baseTime; // 발표 시간
	
	String category; // 자료 구분 코드
	
	String fcstDate; // 예측 일자
	
	String fcstTime; // 예측 시간
	
	String fcstValue; // 예보 값
	
	String nx; // 예보 지점 x 좌표
	
	String ny; // 예보 지점 y 좌표
}
