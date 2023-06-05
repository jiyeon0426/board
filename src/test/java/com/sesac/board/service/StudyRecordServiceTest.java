package com.sesac.board.service;

import com.sesac.board.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService studyRecordService;
    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .study_day("2023.06.05")
                .contents("Test Insert 진행")
                .reg_day(LocalDateTime.now()) //현재시간
                .build();
        studyRecordService.doInsert(study_record);

    }

    @Test
    void doUpdate() {
        /*
        Study_record study_record = new Study_record();
        study_record.setKey_id(3);
        study_record.setStudy_day("2023.06.05");
        study_record.setContents("Test Insert 진행-수정");
        study_record.setReg_day(LocalDateTime.now());

        studyRecordService.doUpdate(study_record);
         */
        Study_record study_record = studyRecordService.doSelectOne(3);
        study_record.setContents("Test Insert 진행-수정3");
        studyRecordService.doUpdate(study_record);

    }

    @Test
    @Transactional //rollback 처리해줌
    void doDelete() {
        studyRecordService.doDelete(3);
    }
}