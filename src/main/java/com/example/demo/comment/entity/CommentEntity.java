package com.example.demo.comment.entity;

import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.member.entitly.MemberEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "tbl_comment")
public class CommentEntity extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int commentNo;
	
	@Column(length = 100, nullable = false)
	String commentContent;
	
	@ManyToOne
	MemberEntity commentWriter;
	
	@ManyToOne
	BoardEntity commentBoardNo;
	
}
