package com.example.demo.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CommentDto {

	int commentNo;
	
	int commentBoardNo;
	
	String commentContent;
	
	String commentWriter;
	
	LocalDateTime regDate;
	
	LocalDateTime modDate;
}
