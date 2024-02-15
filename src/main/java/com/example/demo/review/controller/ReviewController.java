// 2024.02.15   9장 페이지 5장 html부분부터 이어서 하면 된다.

package com.example.demo.review.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.review.dto.ReviewDto;
import com.example.demo.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {	
		
	@Autowired
	ReviewService service;
		
		
	// 리뷰 목록 조회
	@ResponseBody
	@GetMapping("/list")
	List<ReviewDto> list(@RequestParam(name="programNo") int programNo) {
		
		List<ReviewDto> reviewlist = service.getListByProgramNo(programNo);
		
		return reviewlist;	
		
	}
	
	
	// 리뷰 삭제처리
	
	@ResponseBody
	@GetMapping("/remove")
	public HashMap<String, Boolean> remove (@RequestParam (name="reviewNo") int reviewNo) {
		
		// 맵 객체 생성
		HashMap<String, Boolean> map = new HashMap<>();
		
		// 댓글 삭제		
		boolean result = service.remove(reviewNo);
		
		// 처리결과 반환 
		map.put("Success", result);
		
		return map;		
	
}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	
}
