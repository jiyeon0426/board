package com.sesac.board.repository;

import com.sesac.board.entity.Study_member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyMemberRepoTest {

    @Autowired
    StudyMemberRepo studyMemberRepo;
    @Test
    void findByLoginId() {
        Study_member study_member = studyMemberRepo.findByLoginId("ID3");

        System.out.println(study_member);
    }
}