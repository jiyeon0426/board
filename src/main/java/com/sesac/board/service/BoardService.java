package com.sesac.board.service;

import com.sesac.board.entity.Board;
import com.sesac.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    public void write(Board board){
        boardRepository.save(board);
    }
}
