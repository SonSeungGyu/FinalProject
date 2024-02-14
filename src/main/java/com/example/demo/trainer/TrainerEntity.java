package com.example.demo.trainer;

import java.time.LocalDateTime;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name="tbl_trainer")
public class TrainerEntity extends BaseEntity{
	@Id
	@Column(length = 50)
	String trainerId; 		//id
	@Column(length = 50, nullable = false)
	String trainerPassword; //password
	@Column(length = 50, nullable = false)
	String trainerName;		//이름
	
	LocalDateTime regDate; // 회원이 최초로 만들어진 시간
	LocalDateTime modDate; // 회원 정보 수정된 시간
}
