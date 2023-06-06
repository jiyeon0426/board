package com.sesac.board.service;


import com.sesac.board.entity.Study_member;
import com.sesac.board.entity.Study_record;
import com.sesac.board.repository.StudyMemberRepo;
import com.sesac.board.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    /* 전체 Row Select */
    public List<Study_member> doSelectAll(){
        return studyMemberRepo.findAll();
    }

    /* One row Select */
    public Study_member doSelectOne(int key_id){
        return studyMemberRepo.findById(key_id).get();
    }

    /* Insert */
    public void doInsert(Study_member study_member){
        //입력과 저장은 save 사용
        studyMemberRepo.save(study_member);
    }

    /* Update */
    public void doUpdate(Study_member study_member){
        //입력과 저장은 save 사용
        studyMemberRepo.save(study_member);
    }

    /* Delete */
    public void doDelete(int key_id){
        studyMemberRepo.deleteById(key_id);
    }


}
