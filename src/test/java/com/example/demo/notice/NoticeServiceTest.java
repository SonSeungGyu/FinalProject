package com.example.demo.notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.notice.dto.NoticeDto;
import com.example.demo.notice.service.NoticeService;

@SpringBootTest
public class NoticeServiceTest {
	@Autowired
	NoticeService noticeService;
	@Test
	public void 공지사항등록() {
		NoticeDto noticeDto = NoticeDto.builder().noticeTitle("공지사항").noticeContent("사항").noticeWriter("user1").build();
		noticeService.register(noticeDto);
	}
	@Test
	public void 공지사항목록조회() {
		Page<NoticeDto> page = noticeService.getList(1);
		List<NoticeDto> list = page.getContent();
		for(NoticeDto noticeDto : list) {
			System.out.println(noticeDto);
		}
	}
	@Test
	public void 공지사항상세조회() {
		NoticeDto noticeDto = noticeService.read(3);
		System.out.println(noticeDto);
	}
	@Test
	public void 공지사항수정() {
		NoticeDto noticeDto = noticeService.read(3);
		noticeDto.setNoticeTitle("수정");
		noticeDto.setNoticeContent("사항");
		noticeService.modify(noticeDto);
	}
	@Test
	public void 공지사항삭제() {
		noticeService.remove(3);
	}
}
