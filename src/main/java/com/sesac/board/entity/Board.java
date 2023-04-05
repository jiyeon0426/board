package com.sesac.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY는 마리아DB에서 사용하는 것
    private Integer id;
    private String title;
    private String content;

}
