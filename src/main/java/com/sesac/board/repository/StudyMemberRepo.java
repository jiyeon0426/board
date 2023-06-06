package com.sesac.board.repository;

import com.sesac.board.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepo extends JpaRepository<Study_member, Integer> {
}
