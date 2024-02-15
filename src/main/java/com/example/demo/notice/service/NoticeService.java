package com.example.demo.notice.service;

import org.springframework.data.domain.Page;

import com.example.demo.notice.dto.NoticeDto;
import com.example.demo.notice.entity.NoticeEntity;
import com.example.demo.trainer.entity.TrainerEntity;

public interface NoticeService {
	int register(NoticeDto dto);
	
	Page<NoticeDto> getList(int pageNumber);
	
	NoticeDto read(int no);
	
	void modify(NoticeDto dto);
	
	int remove(int no);
	
	
	
	 default NoticeEntity dtoToEntity(NoticeDto dto) {
		  TrainerEntity trainerEntity = TrainerEntity.builder().trainerId(dto.getNoticeWriter()).build();
		  NoticeEntity noticeEntity = NoticeEntity.builder().noticeWriter(trainerEntity)
				  .noticeTitle(dto.getNoticeTitle()).noticeContent(dto.getNoticeContent()).build();
		  return noticeEntity;
	  }
	 default NoticeDto entityToDto(NoticeEntity entity) {
		 NoticeDto noticeDto = NoticeDto.builder().noticeNo(entity.getNoticeNo()).noticeWriter(entity.getNoticeWriter()
				 .getTrainerId()).noticeTitle(entity.getNoticeTitle())
				 .noticeContent(entity.getNoticeContent()).regDate(entity.getRegDate())
				 .modDate(entity.getModDate()).build();
		  return noticeDto;
	 }
	 
}
