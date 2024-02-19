package com.example.demo.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Builder 
public class CommentDto {
	String commentWriter; // 작성자	(MemberEntity와 연동)
		
	int commentNo; // 리뷰넘버번호 .시스템이 자동처리
	
	int board;
	
	String commentContent ; // 내용	
	
//	(변수타입) comment_img // 리뷰 사진 첨부	
	
	LocalDateTime regDate;	// 최초작성
	
	LocalDateTime modDate; // 수정날짜
	
}
