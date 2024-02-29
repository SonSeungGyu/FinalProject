package com.example.demo.board.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

@Controller
@RequestMapping("/board")

public class BoardController {
	@Autowired
	BoardService service;

	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {
		Page<BoardDto> list = service.getList(page);
		model.addAttribute("list", list);
	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String registerPost(BoardDto boardDto, RedirectAttributes redirectAttributes, Principal principal) {
		String id = principal.getName();
		boardDto.setBoardWriter(id);
		int no = service.register(boardDto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/board/list";
	}

	@GetMapping("/read")
	public void read(@RequestParam(name = "boardNo") int boardNo, @RequestParam(defaultValue = "0", name = "page") int page,
			Model model) {
		BoardDto dto = service.read(boardNo);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}

	@GetMapping("/modify")
	public void modify(@RequestParam(name = "boardNo") int boardNo, Model model) {
		BoardDto dto = service.read(boardNo);
		model.addAttribute("dto", dto);
	}

	@PostMapping("/modify")
	public String modifyPost(BoardDto dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("boardNo", dto.getBoardNo());
		return "redirect:/board/read";
	}

	@PostMapping("/remove")
	public String removePost(@RequestParam(name = "boardNo")int boardNo) {
		service.remove(boardNo);
		return "redirect:/board/list";
	}

	
	  @GetMapping("/search") 
	  public void search(String keyword, Model
	  model,@PageableDefault(size = 10,sort = "regDate",direction = Sort.Direction.DESC)
	  Pageable pageable){ 
		  
		  Page<BoardDto> searchList = service.search(keyword,
	  pageable); model.addAttribute("searchList",searchList);
	  
	  }
	  
//	  @GetMapping("/list")
//		public void list(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {
//			Page<BoardDto> list = service.getList(page);
//			model.addAttribute("list", list);
//		}
	 
}
