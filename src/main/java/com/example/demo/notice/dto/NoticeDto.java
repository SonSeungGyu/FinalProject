package com.example.demo.notice.dto;

import java.time.LocalDateTime;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.notice.entity.NoticeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class NoticeDto {
	int noticeNo;
	MemberEntity noticeWriter;
	String noticeTitle;
	String noticeContent;
	LocalDateTime regDate;
	LocalDateTime modDate;
}
