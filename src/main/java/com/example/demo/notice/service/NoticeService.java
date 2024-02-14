package com.example.demo.notice.service;

import org.springframework.data.domain.Page;

import com.example.demo.notice.dto.NoticeDto;

public interface NoticeService {
	int register(NoticeDto dto);
	
	Page<NoticeDto> getList(int pageNumber);
	
	NoticeDto read(int no);
	
	void modify(NoticeDto dto);
	
	int remove(int no);
	
	
	/*
	 * default NoticeDto dtoToEntity(NoticeDto dto) {
	 * 
	 * }
	 */
	 
}
