package com.example.demo.board.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

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

public class BoardDto {
	int boardNo;
	String boardWriter;
	String boardTitle;
	String boardContent;
	LocalDateTime regDate;
	LocalDateTime modDate;
	MultipartFile uploadFile; // 파일 스트림
	String imgPath; // 파일 이름
}
