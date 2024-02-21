package com.example.demo.boardTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

@SpringBootTest
public class BoardServiceTest {
	@Autowired
	BoardService boardService;
	@Test
	public void 게시물등록() {
		BoardDto noticeDto = BoardDto.builder().boardTitle("공지사항").boardContent("사항").boardWriter("user1").build();
		boardService.register(noticeDto);
	}
	@Test
	public void 게시물목록조회() {
		Page<BoardDto> page = boardService.getList(1);
		List<BoardDto> list = page.getContent();
		for(BoardDto boardDto : list) {
			System.out.println(boardDto);
		}
	}
	@Test
	public void 게시물상세조회() {
		BoardDto boardDto = boardService.read(3);
		System.out.println(boardDto);
	}
	@Test
	public void 게시물수정() {
		BoardDto boardDto = boardService.read(3);
		boardDto.setBoardTitle("수정");
		boardDto.setBoardContent("사항");
		boardService.modify(boardDto);
	}
	@Test
	public void 게시물삭제() {
		boardService.remove(3);
	}
	
//	@Test
//	public void 검색기능() {
//		List<BoardDto>list = boardService.search()
//	}
}
