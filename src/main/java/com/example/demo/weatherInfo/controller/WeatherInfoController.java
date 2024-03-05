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
	
	
	
	@GetMapping("/weather") // 날씨 출력 테스트용
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
		
		String sky1 = "흐림";
		String sky2 = "구름많음";
		String sky3 = "맑음";
		String img1 = "/images/cloudy1.png"; // 흐림
		String img2 = "/images/cloudy.png"; // 구름 많음
		String img3 = "/images/sunny.png"; // 맑음
		for(int i = 0; i < root.response.body.items.item.size(); i++) {
			if("DB01".equals(root.response.body.items.item.get(i).wfCd)) {
				root.response.body.items.item.get(i).setImg(img3);
			} else if("DB03".equals(root.response.body.items.item.get(i).wfCd)) {
				root.response.body.items.item.get(i).setImg(img2);
			} else if("DB04".equals(root.response.body.items.item.get(i).wfCd)) {
				root.response.body.items.item.get(i).setImg(img1);
			} else {
				root.response.body.items.item.get(i).setImg(" ");
			}
		}
		
		if(sky1.equals(skyRoot.response.body.items.item.get(0).wf3Pm)) {
			skyRoot.response.body.items.item.get(0).setWf3PmImg(img1);
		} else if(sky2.equals(skyRoot.response.body.items.item.get(0).wf3Pm)){
			skyRoot.response.body.items.item.get(0).setWf3PmImg(img2);
		} else if(sky3.equals(skyRoot.response.body.items.item.get(0).wf3Pm)){
			skyRoot.response.body.items.item.get(0).setWf3PmImg(img3);
		} else {
			skyRoot.response.body.items.item.get(0).setWf3PmImg(" ");
		}
		
		if(sky1.equals(skyRoot.response.body.items.item.get(0).wf4Pm)) {
			skyRoot.response.body.items.item.get(0).setWf4PmImg(img1);
		} else if(sky2.equals(skyRoot.response.body.items.item.get(0).wf4Pm)){
			skyRoot.response.body.items.item.get(0).setWf4PmImg(img2);
		} else if(sky3.equals(skyRoot.response.body.items.item.get(0).wf4Pm)){
			skyRoot.response.body.items.item.get(0).setWf4PmImg(img3);
		} else {
			skyRoot.response.body.items.item.get(0).setWf4PmImg(" ");
		}
		
		if(sky1.equals(skyRoot.response.body.items.item.get(0).wf5Pm)) {
			skyRoot.response.body.items.item.get(0).setWf5PmImg(img1);
		} else if(sky2.equals(skyRoot.response.body.items.item.get(0).wf5Pm)){
			skyRoot.response.body.items.item.get(0).setWf5PmImg(img2);
		} else if(sky3.equals(skyRoot.response.body.items.item.get(0).wf5Pm)){
			skyRoot.response.body.items.item.get(0).setWf5PmImg(img3);
		} else {
			skyRoot.response.body.items.item.get(0).setWf5PmImg(" ");
		}
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
	
}
