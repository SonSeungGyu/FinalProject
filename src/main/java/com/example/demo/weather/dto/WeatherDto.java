package com.example.demo.weather.dto;

public class WeatherDto {
	
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
