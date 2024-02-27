package com.example.demo.comment.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;

	// 게시물별 댓글 목록 조회
	@ResponseBody
	@GetMapping("/list")
	public List<CommentDto> list(@RequestParam(name = "boardNo") int boardNo) {
		List<CommentDto> commentlist = service.getListByCommentBoardNo(boardNo);

		return commentlist;
	}

	@ResponseBody
	@PostMapping("/register")
	public HashMap<String, Boolean> register(CommentDto dto, Principal principal) { // 인증 객체
		HashMap<String, Boolean> map = new HashMap<>();
		String commentWriter = principal.getName(); // 인증객체에서 사용자 아이디 꺼내기
		dto.setCommentWriter(commentWriter);
		service.register(dto);
		map.put("success", true);
		return map;
	}

	@ResponseBody
	@GetMapping("/remove")
	public HashMap<String, Boolean> remove(@RequestParam(name = "commentNo") int boardNo) {
		HashMap<String, Boolean> map = new HashMap<>();
		boolean result = service.remove(boardNo);
		map.put("success", result);
		return map;
	}

}