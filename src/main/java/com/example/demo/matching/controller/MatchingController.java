package com.example.demo.matching.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.court.dto.CourtDto;
import com.example.demo.court.service.CourtService;
import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchVictory;
import com.example.demo.matching.service.MatchingService;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.weatherInfo.service.WeatherInfoService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/matching")
public class MatchingController {
	
	@Autowired
	MatchingService matchingService;
	@Autowired
	CourtService courtService;
	@Autowired
	WeatherInfoService weatherInfoService;
	
	@GetMapping("/register")
	public void matchingRegister(Model model) {
		List<CourtDto> list = courtService.list();
		model.addAttribute("list", list);
	}
	
	@PostMapping("/register")
	public String registerPost(MatchingDto matchingDto, RedirectAttributes redirectAttributes, Principal principal) {
		String id = principal.getName();
		matchingDto.setMatchingHome(id);
		int no = matchingService.creatMatching(matchingDto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/matching/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws IOException {
		List<MatchingDto> list = matchingService.getList();
		
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectMapper tempMapper = new ObjectMapper();
		
		ObjectMapper skyMapper = new ObjectMapper();
		//분석할 수 없는 구문을 무시하는 옵션 설정
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		tempMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		skyMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		
		//날씨 데이터 가져오기
		String weather = weatherInfoService.getWeather();
		String tempWeather = weatherInfoService.forceastTempWeather();
		String skyWeather = weatherInfoService.forceastSkyWeather();
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
		model.addAttribute("list", list);
		model.addAttribute("weather0",root.response.body.items.item.get(0));
		model.addAttribute("weather2",root.response.body.items.item.get(2));
		model.addAttribute("weather4",root.response.body.items.item.get(4));
		model.addAttribute("tempWeather", tempRoot.response.body.items.item.get(0));
		model.addAttribute("skyWeather", skyRoot.response.body.items.item.get(0));
		
	}
	
	@PostMapping("/applyMatch")
	 public String applyMatch(MatchingDto dto, Principal principal,RedirectAttributes redirectAttributes) {
		 String id = principal.getName();
		 MemberDto memberDto = MemberDto.builder().memberId(id).build();
		 matchingService.applyMatch(dto,memberDto);
		 redirectAttributes.addFlashAttribute("msg", dto.getMatchingNo());
		 return "redirect:/matching/matchingRead?matchingNo=" + dto.getMatchingNo();
	 }
	 
	 @GetMapping("/read")
	 public void read(@RequestParam(name = "matchingNo")int matchingNo, Model model) {
		 MatchingDto dto = matchingService.read(matchingNo);
		 model.addAttribute("dto", dto);
	 }
	 
	 @GetMapping("/matchedList")
		public void matchedList(Model model) {
			List<MatchingDto> list = matchingService.getList();
			model.addAttribute("list", list);
			
	 }
	 @GetMapping("/matchingRead")
	 public void matchingRead(@RequestParam(name = "matchingNo")int matchingNo,Model model) {
		 MatchingDto dto = matchingService.read(matchingNo);
		 model.addAttribute("dto", dto);
	 }
	 @PostMapping("/matchVictory")
	 public String matchVictory(@RequestParam("matchVictory") String matchVictory, MatchingDto dto, RedirectAttributes redirectAttributes) {
	     MemberDto homeTeam = MemberDto.builder().memberId(dto.getMatchingHome()).build();
	     MemberDto awayTeam = MemberDto.builder().memberId(dto.getMatchingAway()).build();
	     if (matchVictory.equals("WIN")) {
	         // WIN인 경우의 처리 로직
	         matchingService.matchVictory(dto, homeTeam, awayTeam, MatchVictory.WIN);
	     } else if (matchVictory.equals("LOSE")) {
	         // LOSE인 경우의 처리 로직
	         matchingService.matchVictory(dto, homeTeam, awayTeam, MatchVictory.LOSE);
	     }
	     redirectAttributes.addFlashAttribute("msg", dto.getMatchingNo());
	     return "redirect:/matching/matchedList";
	 }

}

