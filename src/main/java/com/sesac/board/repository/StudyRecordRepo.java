package com.sesac.board.repository;

import com.sesac.board.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecordRepo extends JpaRepository<Study_record, Integer> {
}
