package com.example.demo.notice.entity;


import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.trainer.entity.TrainerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_notice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class NoticeEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int noticeNo;
	
	@Column(length = 50, nullable = false)
	TrainerEntity noticeWriter;
	
	@Column(length = 100, nullable = false)
	String noticeTitle;
	
	@Column(length = 300, nullable = false)
	String noticeContent;
	
}
