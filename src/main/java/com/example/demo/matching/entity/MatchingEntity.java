package com.example.demo.matching.entity;

import java.time.LocalDate;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "tbl_matching")
public class MatchingEntity {


   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   int matchingNo;
   
   @Column(nullable=false)
   LocalDate matchingDate;//매칭 날짜
   
   @Column(nullable=false)
   int matchingTime;      //매칭 시간을 숫자값으로 주고 처리
   
   @Column(nullable=false)
   int teamHome;         //먼저 매칭 등록한 팀
   
   @Column(nullable=true)  //null이 가능하도록 한건 매치등록시 매칭에는 home팀만 등록 되기때문에?
   int teamAway;         //후에 매칭 신청한 팀
   
   @Column(nullable=false)
   int courtNo;         //구장 번호
   
}

