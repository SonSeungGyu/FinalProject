package com.example.demo.weatherInfo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.weatherInfo.service.WeatherInfoService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/weather")
public class WeatherInfoController {

	@Autowired
	WeatherInfoService service;
	
	/*
	 * @GetMapping("/main2") public void getWeather(Model model) throws IOException
	 * { // service.jsonToDto();
	 * 
	 * ObjectMapper mapper = new ObjectMapper();
	 * 
	 * //분석할 수 없는 구문을 무시하는 옵션 설정
	 * mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	 * 
	 * //날씨 데이터 가져오기 String weather = service.getWeather();
	 * 
	 * //json 문자열을 클래스로 변환 Root root = null; root = mapper.readValue(weather,
	 * Root.class); //api 문서 참고
	 * model.addAttribute("weather0",root.response.body.items.item.get(0));
	 * model.addAttribute("weather1",root.response.body.items.item.get(1));
	 * model.addAttribute("weather2",root.response.body.items.item.get(2));
	 * model.addAttribute("weather3",root.response.body.items.item.get(3));
	 * model.addAttribute("weather4",root.response.body.items.item.get(4));
	 * model.addAttribute("weather5",root.response.body.items.item.get(5));
	 * model.addAttribute("weather6",root.response.body.items.item.get(6)); //
	 * model.addAttribute("weather7",root.response.body.items.item.get(7)); //
	 * model.addAttribute("weather8",root.response.body.items.item.get(8)); }
	 */
	
	@GetMapping("/main2")
	public void getWeather(Model model) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectMapper tempMapper = new ObjectMapper();
		
		ObjectMapper skyMapper = new ObjectMapper();
		//분석할 수 없는 구문을 무시하는 옵션 설정
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		tempMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		skyMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		
		//날씨 데이터 가져오기
		String weather = service.getWeather();
		String tempWeather = service.forceastTempWeather();
		String skyWeather = service.forceastSkyWeather();
		//json 문자열을 클래스로 변환
		
		TempRoot tempRoot = null;
		tempRoot = tempMapper.readValue(tempWeather, TempRoot.class);
		SkyRoot skyRoot =null;
		skyRoot = skyMapper.readValue(skyWeather, SkyRoot.class);
		Root root = null;	
		root = mapper.readValue(weather, Root.class);
		//api 문서 참고 
		model.addAttribute("weather0",root.response.body.items.item.get(0));
		model.addAttribute("weather1",root.response.body.items.item.get(1));
		model.addAttribute("weather2",root.response.body.items.item.get(2));
		model.addAttribute("weather3",root.response.body.items.item.get(3));
		model.addAttribute("weather4",root.response.body.items.item.get(4));
		model.addAttribute("weather5",root.response.body.items.item.get(5));
		model.addAttribute("weather6",root.response.body.items.item.get(6));
		model.addAttribute("tempWeather", tempRoot.response.body.items.item.get(0));
		model.addAttribute("skyWeather", skyRoot.response.body.items.item.get(0));
	}
	
	//테스트용
	@GetMapping("/weather")
	public void we() {
		
	}
}
