package com.example.demo.member.entitly;

import com.example.demo.allBaseEtity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "tbl_member")
public class MemberEntity extends BaseEntity {

	@Id
	@Column(length = 50)
	String memberId; // 회원 아이디(pk값)
	
	@Column(length = 50, nullable = false)
	String memberPassword; // 회원 비밀번호
	
	@Column(length = 50, nullable = false)
	String memberName; // 회원 이름
	
	@Column(length = 50, nullable = false)
	String memberAddress; // 회원 주소
	
	@Column(length = 50, nullable = false)
	String memberEmail; // 회원 이메일
	
	@Column(length = 50, nullable = false)
	String memberNumber; // 회원 전화번호
	
	@Column(length = 50, nullable = false)
	String memberBirthDay; // 회원 생년월일
	
	@Column(length = 100,nullable = false)
	 String role; //사용자 등급
	
	
	
}
