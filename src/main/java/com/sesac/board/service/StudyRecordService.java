package com.sesac.board.service;

import com.sesac.board.entity.Study_record;
import com.sesac.board.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepo studyRecordRepo;
    /* 전체 Row Select */
    public List<Study_record> doSelectAll(){
        return studyRecordRepo.findAll();
    }

    /* One row Select */
    public Study_record doSelectOne(int key_id){
        return studyRecordRepo.findById(key_id).get();
    }

    /* Insert */
    public void doInsert(Study_record study_record){
        //입력과 저장은 save 사용
        studyRecordRepo.save(study_record);
    }

    /* Update */
    public void doUpdate(Study_record study_record){
        //입력과 저장은 save 사용
        studyRecordRepo.save(study_record);
    }

    /* Delete */
    public void doDelete(int key_id){
        studyRecordRepo.deleteById(key_id);
    }
}
