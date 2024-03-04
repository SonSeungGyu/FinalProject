package com.example.demo.weatherInfo.service;

import java.io.IOException;




public interface WeatherInfoService {
	
	public String getWeather()throws IOException;
	
	public String forceastTempWeather() throws IOException;
	
	public String forceastSkyWeather() throws IOException;
//	default void jsonToDto() throws IOException{
//		
//		//json 문자열을 클래스로 변환해주는 매퍼 클래스 생성
//		ObjectMapper mapper = new ObjectMapper();
//		
//		//분석할 수 없는 구문을 무시하는 옵션 설정
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//		
//		//날씨 데이터 가져오기
//		String weather = getWeather();
//		
//		//json 문자열을 클래스로 변환
//		Root root = null;
//		root = mapper.readValue(weather, Root.class);
//		
//		//결과 코드만 추출
//		System.out.println(root.response.header.resultCode);
//		
//		//결과 메세지만 추출
//		System.out.println(root.response.header.resultMsg);
//		
//		
//		System.out.println(root.response.body.items.item.get(0).wfCd);
//	}

}
