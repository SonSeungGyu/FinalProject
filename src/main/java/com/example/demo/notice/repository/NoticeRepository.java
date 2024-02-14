package com.example.demo.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.notice.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer>{

}
