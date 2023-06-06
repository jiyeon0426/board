package com.sesac.board.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="STUDY_MEMBER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Study_member {

    /*
        IDENTITY - @GeneratedValue(strategy = GenertationType.IDEENTITY)
                    기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도 데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성
        SEQUENCE - @GeneratedValue(strategy = GenertationType.SEQUNCE)
                    데이터 베이스의 Sequence Object를 사용하여 데이터베이스가 자동으로 기본키를 생성해준다.
                   @SequenceGenerator 어노테이션이 필요하다.
        TABLE - @GenerateValue(strategy = GenerationType.TABLE)
        AUTO - @GenerateValue(strategy = GenerationType.AUTO)
                기본 설정 값으로 각 데이터베이스에 따라 기본키를 자동으로 생성한다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "login_id")
    private String loginId;

    private String password;

    private String name;

    private String email;

    private String role;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="reg_day", updatable = false)
    private LocalDateTime regDay;
}
