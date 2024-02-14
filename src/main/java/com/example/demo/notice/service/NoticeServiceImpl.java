package com.example.demo.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.notice.dto.NoticeDto;
import com.example.demo.notice.repository.NoticeRepository;

@Service

public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeRepository repository;

	@Override
	public int register(NoticeDto dto) {
		
		return 0;
	}

	@Override
	public Page<NoticeDto> getList(int pageNumber) {
		
		return null;
	}

	@Override
	public NoticeDto read(int no) {
		
		return null;
	}

	@Override
	public void modify(NoticeDto dto) {
		
	}

	@Override
	public int remove(int no) {
		return 0;
	}
	
}
