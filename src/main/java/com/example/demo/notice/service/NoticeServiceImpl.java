package com.example.demo.notice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.notice.dto.NoticeDto;
import com.example.demo.notice.entity.NoticeEntity;
import com.example.demo.notice.repository.NoticeRepository;

@Service

public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeRepository repository;

	@Override
	public int register(NoticeDto dto) {
		NoticeEntity noticeEntity = dtoToEntity(dto);
		repository.save(noticeEntity);
		int newNo = noticeEntity.getNoticeNo();
		return newNo;
	}

	@Override
	public Page<NoticeDto> getList(int pageNumber) {
		int pageNum = (pageNumber == 0) ? 0 : pageNumber -1;
		Pageable pageable = PageRequest.of(pageNum, 10,Sort.by("noticeNo").descending());
		Page<NoticeEntity> entityPage = repository.findAll(pageable);
		Page<NoticeDto> dtoPage = entityPage.map(entity -> entityToDto(entity));
		return dtoPage;
	}

	@Override
	public NoticeDto read(int no) {
		Optional<NoticeEntity> optional = repository.findById(no);
		if(optional.isPresent()) {
			NoticeEntity noticeEntity = optional.get();
			NoticeDto noticeDto = entityToDto(noticeEntity);
			return noticeDto;
		} else {
			return null;
		}
		
	}

	@Override
	public void modify(NoticeDto dto) {
		Optional<NoticeEntity> optional = repository.findById(dto.getNoticeNo());
		NoticeEntity noticeEntity = optional.get();
		noticeEntity.setNoticeTitle(dto.getNoticeTitle());
		noticeEntity.setNoticeContent(dto.getNoticeContent());
		repository.save(noticeEntity);
	}

	@Override
	public int remove(int no) {
		Optional<NoticeEntity> optional = repository.findById(no);
		if(optional.isPresent()) {
			repository.deleteById(no);
			return 1;
		} else {
			return 0;
		}
		
	}
	
}
