package com.example.demo.notice;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.notice.entity.NoticeEntity;
import com.example.demo.notice.repository.NoticeRepository;

@SpringBootTest
public class NoticeRepositoryTest {
	@Autowired
	NoticeRepository repository;
	
	@Test
	public void 공지사항등록() {
		MemberEntity memberEntity = MemberEntity.builder().memberId("admin").build();
		NoticeEntity noticeEntity = NoticeEntity.builder().noticeTitle("ㅇㅇ").noticeContent("ㅁㅁ").noticeWriter(memberEntity).build(); repository.save(noticeEntity);
		repository.save(noticeEntity);
	}
	@Test
	public void 공지사항전체조회() {
		List<NoticeEntity> list =  repository.findAll();
		for(NoticeEntity noticeEntity : list) {
			System.out.println(noticeEntity);
		}
	}
	@Test
	public void 공지사항단건조회() {
		Optional<NoticeEntity> optional = repository.findById(2);
		System.out.println(optional);
	}
	@Test
	public void 공지사항수정() {
		Optional<NoticeEntity> optional = repository.findById(2);
		NoticeEntity noticeEntity = optional.get();
		noticeEntity.setNoticeTitle("수정");
		noticeEntity.setNoticeContent("aa");
		repository.save(noticeEntity);
	}
	@Test
	public void 공지사항삭제() {
		repository.deleteById(2);
	}
}
